// This is a custom hook so that selectedUser doesn't get lost when the page is refreshed
import {useEffect, useState} from "react";

export default function usePersistentState(key, initialValue) {
    const [value, setValue] = useState(() => {
        const savedValue = localStorage.getItem(key);
        return savedValue !== null ? JSON.parse(savedValue) : initialValue;
    });

    useEffect(() => {
        localStorage.setItem(key, JSON.stringify(value));
    }, [key, value]);
    return [value, setValue];
}