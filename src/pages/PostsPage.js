import React, { useEffect, useState } from 'react';
import {Container, Row, Col, Button} from 'react-bootstrap';
import {deleteData, getData, postData, putData} from "../services/api-services";
import { format } from 'date-fns';  // Import date-fns
import '../styles/PostsPage.css';
import PostCard from "../components/PostCard";
import {useNavigate, useParams} from "react-router-dom";
import PostModal from "../components/PostModal";

export default function PostsPage( {selectedUserId}) {
    const [posts, setPosts] = useState([]);
    const [error, setError] = useState(null);
    const [showPostEditModal, setShowEditPostModal] = useState(false);
    const [selectedPost, setSelectedPost] = useState({});
    const user = useParams();
    const navigate = useNavigate();

    function handleAddPost() {
        setSelectedPost({});
        setShowEditPostModal(true);
    }
    function handleEditPost(post) {
        setSelectedPost(post);
        setShowEditPostModal(true);
    }

    useEffect(() => {
        fetchPosts();
    }, []);

    const fetchPosts = async () => {
        const API_URL =
            user.userId
                ? `http://localhost:8080/posts/users/${user.userId}`
                : "http://localhost:8080/posts";
        try {
            const data = await getData(API_URL);
            setPosts(data);
        } catch (error) {
            console.error("Error fetching posts: ", error);
            setError(error.message);
        }
    }

    const fetchUserByUserName = async (userName) => {
        const API_URL = `http://localhost:8080/users/username/${userName}`;
        try {
            const data = await getData(API_URL);
            return data;
        } catch (error) {
            console.error("Error fetching user with user name: ", userName, error);
            setError(error.message);
        }
    }

    const handleDeletePost = async (postId) => {
        const API_URL = `http://localhost:8080/posts`;
        try {
            const response = await deleteData(API_URL, postId);
            await fetchPosts();
            if (!response.ok) {
                // Check for response status
                throw new Error('Failed to delete post');
            }
            console.log('Post deleted successfully');
        } catch (error) {
            console.error("Error deleting post: ", error);
        }
    };


    const handleSavePost = async (data, postId) => {
        const API_URL = `http://localhost:8080/posts`;
        const request_data = {
            userId: selectedUserId,
            postImageUrl: data.postImageUrl || '',
            postDescription: data.postDescription || '',
        }
        try {
            if (postId) {
                //Update existing post
                await putData(API_URL, postId, data);
            } else {
                // Create a new post
                    //GET THE USER_ID FROM THE USERNAME
                // const user = await fetchUserByUserName(data.userName);
                // request_data.userId = user.userId;
                await postData(API_URL, request_data);
                console.log('Data being sent', data);
                console.log({selectedUserId});
            }
            await fetchPosts(); // Refresh the list of posts after saving
            setShowEditPostModal(false);
        } catch (error) {
            console.error("Error fetching post: with postId", postId, error);
        }
    }

    return (
        <div className="main-content">
            <h1>Posts</h1>
            <Container fluid>
                <Row className="g-4 justify-content-center px-lg-5">
                    {posts.length > 0 ? (
                        posts.map((post) => (
                            <Col
                                key={post.postId}
                                className="mb-4"
                            >
                                <PostCard
                                    post={post}
                                    onDelete={handleDeletePost}
                                    onEdit={handleEditPost}
                                />
                            </Col>
                        ))
                    ) : (
                        <p>No posts found</p>
                    )}
                </Row>
                <Button className={"add-post-button"} onClick={handleAddPost}>+</Button>
                <Button className={"goto-users-button"} onClick={() => navigate("/")}>Users</Button>
                <PostModal post={selectedPost} onSave={handleSavePost} show={showPostEditModal} onHide={() => setShowEditPostModal(false)}/>
            </Container>
        </div>
    );
}
