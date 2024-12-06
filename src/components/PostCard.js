import React from 'react';
import {Button, Card} from "react-bootstrap";
import '../styles/PostCard.css';
import {useNavigate} from "react-router-dom";
import {format} from "date-fns";

export default function PostCard({ post, onDelete, onEdit }) {
    const navigate = useNavigate();
    const handleProfileClick = () => {
        navigate(`/profile/${post.userId}`);
    };



    return (
        <Card style={{ width: '18rem' }} className="mb-3 shadow rounded-4">
            <Card.Header className="bg-teal text-white text-start">
                <div className="d-flex align-items-center">
                    <Card.Img
                        src={post.userImageUrl}
                        alt="Profile"
                        className="rounded-circle profile-picture me-2"
                        onClick={handleProfileClick}
                        style={{cursor: 'pointer'}}
                    />
                    <Card.Text
                        onClick={handleProfileClick}
                        style={{cursor: 'pointer'}}>
                            {post.userName}
                    </Card.Text>
                </div>
            </Card.Header>
            <Card.Body className="text-start">
                <div className="image-container">
                    <Card.Img
                        src={post.postImageUrl}
                        alt="Post"
                        className="card-img-top"
                    />
                </div>
                <Card.Text className="post-description">
                    {post.postDescription}
                </Card.Text>
                <Card.Text className="mt-3 text-muted">
                    <small>Posted on: {format(new Date(post.createdAt), 'dd/MM/yyyy')}</small>
                </Card.Text>
            </Card.Body>
            <Card.Footer className="d-flex justify-content-around">
                <Button className="profile-buttons rounded-4 danger" onClick={() => onDelete(post.postId)}>
                    Delete
                </Button>
                <Button className="profile-buttons rounded-4"  onClick={() => onEdit(post)}>
                    Edit
                </Button>
            </Card.Footer>
        </Card>
    );
}
