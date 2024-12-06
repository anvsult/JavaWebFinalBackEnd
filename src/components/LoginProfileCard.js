import React from 'react';
import { Button, Card } from 'react-bootstrap';
import '../styles/ProfileCard.css';
import {useNavigate} from "react-router-dom";
import {format} from "date-fns";

export default function LoginProfileCard({ profile, onDelete, onEdit, onLogin }) {

    return (
        <div className="d-flex justify-content-center align-items-center vh-100">
            <Card style={{ width: '22rem', borderRadius: '15px' }} className="mb-3 shadow-lg">
                <Card.Header
                    className="bg-teal text-white text-center rounded-top">
                    <h3>Profile</h3>
                </Card.Header>
                <Card.Body className="text-center">
                    <Card.Img
                        variant="top"
                        src={profile.profilePictureUrl}
                        alt="Profile"
                        className=" profile-picture"
                    />
                    <Card.Title className="card-title mt-3">{profile.userName}</Card.Title>
                </Card.Body>
                <Card.Footer className="d-flex justify-content-around">
                    <Button className="profile-buttons rounded-4" variant="outline-teal" onClick={() => onLogin(profile.userId)}> Login as user</Button>
                    <Button className="profile-buttons rounded-4 danger" onClick={() => onDelete(profile.userId)}>
                        Delete
                    </Button>
                    <Button className="profile-buttons rounded-4"  onClick={() => onEdit(profile)}>
                        Edit
                    </Button>
                </Card.Footer>
            </Card>
        </div>
    );
}

