import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {Button, Form, Modal} from "react-bootstrap";

export default function PostModal({post, onSave, show, onHide}) {
    const isPostEmpty = post.postId === undefined;

    const [formData, setFormData] = useState({
        // userName: '',
        postImageUrl: '',
        postDescription: '',

    })

    useEffect(() => {
        if (post) {
            setFormData({
                // userName: post.userName || '',
                postImageUrl: post.postImageUrl || '',
                postDescription: post.postDescription || '',
            })
        }
    }, [post])

    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData((prev) => ({...prev, [name]: value}));
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        onSave(formData, post ? post.postId : null);
    }


    return (
        <Modal show={show} onHide={onHide}>
            <Modal.Header closeButton>
                <Modal.Title>{isPostEmpty ? "Create Post" : "Edit Post" }</Modal.Title>

            </Modal.Header>
            <Modal.Body>
                <Form onSubmit={handleSubmit}>
                    {/*{isPostEmpty ?*/}
                    {/*    <Form.Group className={'mb-3'}>*/}
                    {/*        <Form.Label>User Name</Form.Label>*/}
                    {/*        <Form.Control type={'text'} name={'userName'} onChange={handleChange}*/}
                    {/*                      value={formData.userName} required/>*/}
                    {/*    </Form.Group> : null*/}
                    {/*}*/}
                    <Form.Group className={'mb-3'}>
                        <Form.Label>Image</Form.Label>
                        <Form.Control type={'text'} name={'postImageUrl'} onChange={handleChange} value={formData.postImageUrl} required/>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Description</Form.Label>
                        <Form.Control type={'text'} name={'postDescription'} onChange={handleChange} value={formData.postDescription} required/>
                    </Form.Group>
                    <Button
                        type="submit"
                        size="lg"
                        className="w-100 mt-3 submit-button"
                    >
                        {isPostEmpty ? 'Create Post' : 'Update Post'}
                    </Button>
                </Form>
            </Modal.Body>
            <Modal.Footer>

            </Modal.Footer>
        </Modal>
    )
}