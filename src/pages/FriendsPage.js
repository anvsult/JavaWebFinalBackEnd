import React, { useEffect, useState } from 'react';
import { getData } from "../services/api-services";
import { useParams } from "react-router-dom";
import { Col, Container, Row } from "react-bootstrap";
import { format } from "date-fns";
import ProfileCard from "../components/ProfileCard";

export default function FriendsPage() {
    const { userId } = useParams();
    const [friendships, setFriendships] = useState([]);
    const [error, setError] = useState(null);
    const [friendProfiles, setFriendProfiles] = useState([]);
    const API_URL = `http://localhost:8080/friendships/${userId}`;

    useEffect(() => {
        fetchFriendships();
    }, [userId]);

    const fetchFriendships = async () => {
        try {
            const data = await getData(API_URL);
            setFriendships(data);
            fetchProfiles(data);
        } catch (error) {
            console.error("Error fetching friendships: ", error);
            setError(error.message);
        }
    };

    const fetchProfiles = async (friendships) => {
        try {
            const profiles = [];
            for (const friendship of friendships) {
                const friendId = friendship.sourceUserId === parseInt(userId)
                    ? friendship.targetUserId
                    : friendship.sourceUserId;
                const friendProfile = await getData(`http://localhost:8080/users/${friendId}`);
                profiles.push(friendProfile);
            }
            setFriendProfiles(profiles);
        } catch (error) {
            console.error("Error fetching friend profiles: ", error);
            setError(error.message);
        }
    };

    return (
        <div className="main-content">
            <Container fluid>
                <Row className="g-4 justify-content-center px-lg-5">
                    {friendProfiles.length > 0 ? (
                        friendProfiles.map((profile) => (
                            <Col key={profile.userId} className="mb-4">
                                <ProfileCard
                                    profile={profile}
                                />
                            </Col>
                        ))
                    ) : (
                        <p>No friendships found</p>
                    )}
                </Row>
            </Container>
        </div>
    );
}
