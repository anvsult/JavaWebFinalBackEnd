import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {Button, Form, Modal} from "react-bootstrap";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import '../styles/UserModal.css';


export default function UserModal({user, onSave, show, onHide}) {
    const isUserEmpty = user.userId === undefined;

    const [formData, setFormData] = useState({
        userName: '',
        email: '',
        dob: '',
        profilePictureUrl: '',
        bio: '',

    })

    useEffect(() => {
        if (user) {
            setFormData({
                userName: user.userName || '',
                email: user.email || '',
                dob: user.dob || '',
                profilePictureUrl: user.profilePictureUrl || '',
                bio: user.bio || '',
            })
        }
    }, [user])

    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData((prev) => ({...prev, [name]: value}));
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        onSave(formData, user ? user.userId : null);
    }


    return (
        <Modal show={show} onHide={onHide}>
            <Modal.Header closeButton>
                <Modal.Title>{isUserEmpty ? "Add User" : "Edit User" }</Modal.Title>

            </Modal.Header>
            <Modal.Body>
                <Form onSubmit={handleSubmit}>
                    {isUserEmpty ?
                        <Form.Group className={'mb-3'}>
                            <Form.Label>User Name</Form.Label>
                            <Form.Control type={'text'} name={'userName'} onChange={handleChange}
                                          value={formData.userName} required/>
                        </Form.Group> : null
                    }
                    <Form.Group className={'mb-3'}>
                        <Form.Label>Email</Form.Label>
                        <Form.Control
                            type={'email'}
                            name={'email'}
                            onChange={handleChange}
                            value={formData.email}
                            required
                            isInvalid={formData.email && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)}
                        />
                        <Form.Control.Feedback type="invalid">
                            Please enter a valid email address.
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className={'mb-3'}>
                        <Form.Label>Date of Birth</Form.Label><br/>
                        <DatePicker
                            selected={formData.dob ? new Date(formData.dob) : null}
                            onChange={(date) =>
                                handleChange({
                                    target: {
                                        name: 'dob',
                                        value: date ? date.toISOString().split('T')[0] : '',
                                    },
                                })
                            }
                            dateFormat="yyyy-MM-dd"
                            className="form-control"
                            isClearable
                            required
                        />
                    </Form.Group>
                    {/*<Form.Group className={'mb-3'}>*/}
                    {/*        <Form.Label>Date of Birth</Form.Label>*/}
                    {/*        <input*/}
                    {/*            type="date"*/}
                    {/*            className="form-control custom-date-input"*/}
                    {/*            value={formData.dob}*/}
                    {/*            onChange={(e) => setFormData(e.target.value)}/>*/}
                    {/*</Form.Group>*/}
                    <Form.Group className={'mb-3'}>
                        <Form.Label>Profile Picture</Form.Label>
                        <Form.Control type={'text'} name={'profilePictureUrl'} onChange={handleChange} value={formData.profilePictureUrl} required/>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Bio</Form.Label>
                        <Form.Control
                            as="textarea"
                            name={'bio'}
                            rows={3}
                            onChange={handleChange}
                            value={formData.bio}
                        />
                    </Form.Group>
                    <Button
                        type="submit"
                        size="lg"
                        className="w-100 mt-3 submit-button"
                    >
                        {isUserEmpty ? 'Add User' : 'Update User'}
                    </Button>
                </Form>
            </Modal.Body>
            <Modal.Footer>

            </Modal.Footer>
        </Modal>
    )
}