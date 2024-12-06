import React, {useEffect, useState} from "react";
import {deleteData, getData, postData, putData} from "../services/api-services";
import {Button, Col, Container, Row} from "react-bootstrap";
import LoginProfileCard from "../components/LoginProfileCard";
import UserModal from "../components/UserModal";

export default function UsersPage({onLogin}) {
    const [users, setUsers] = useState([]);
    const [error, setError] = useState(null);
    const [showEditUserModal, setShowEditUserModal] = useState(false);
    const [selectedUser, setSelectedUser] = useState({});

    useEffect(() => {
        fetchUsers();
    }, []);

    function handleAddUser() {
        setSelectedUser({});
        setShowEditUserModal(true);
    }
    function handleEditUser(user) {
        setSelectedUser(user);
        setShowEditUserModal(true);
    }

    const fetchUsers = async () => {
        const API_URL = "http://localhost:8080/users";
        try {
            const data = await getData(API_URL);
            setUsers(data);
        } catch (error) {
            console.error("Error fetching posts: ", error);
            setError(error.message);
        }
    }

    const handleDeleteUser = async (userId) => {
        const API_URL = `http://localhost:8080/users`;
        try {
            const response = await deleteData(API_URL, userId);
            await fetchUsers();
            if (!response.ok) {
                // Check for response status
                throw new Error('Failed to delete user');
            }
            console.log('User deleted successfully');
        } catch (error) {
            console.error("Error deleting user: ", error);
        }
    };


    const handleSaveUser = async (data, userId) => {
        const API_URL = `http://localhost:8080/users`;
        try {
            if (userId) {
                //Update existing user
                await putData(API_URL, userId, data);
            } else {
                // Create a new user
                data.dob = data.dob + 'T00:00:00.000+00:00';
                await postData(API_URL, data);
                console.log('Data being sent', data);
            }
            await fetchUsers(); // Refresh the list of users after saving
            setShowEditUserModal(false);
        } catch (error) {
            console.error("Error fetching users: with userId", userId, error);
        }
    }

    return (
        <div className="main-content">
            <h1>Users</h1>
            <Container fluid>
                <Row className="g-4 justify-content-center px-lg-5">
                    {users.length > 0 ? (
                        users.map((user) => (
                            <Col
                                key={user.userId}
                                className="mb-4"
                            >
                                <LoginProfileCard
                                    profile={user}
                                    onEdit={handleEditUser}
                                    onDelete={handleDeleteUser}
                                    onLogin={onLogin}

                                />
                            </Col>
                        ))
                    ) : (
                        <p>No users found</p>
                    )}
                </Row>
                <Button className={"add-post-button"} onClick={handleAddUser}>+</Button>
                <UserModal user={selectedUser} onSave={handleSaveUser} show={showEditUserModal}
                           onHide={() => setShowEditUserModal(false)}/>
            </Container>
        </div>

    )
}