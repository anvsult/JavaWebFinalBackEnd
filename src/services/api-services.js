export const getData = async (API_URL) => {
    const response = await fetch(API_URL, {
        method: 'GET'
    });
    return await response.json();
};

export const postData = async (API_URL, newData) => {
    return await fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newData)
    });
};

export const putData = async (API_URL, id, updatedData) => {
    // eslint-disable-next-line no-template-curly-in-string
    return await fetch(`${API_URL}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedData)
    });
};
export const deleteData = async (API_URL, id) => {
    try {
        const url = API_URL + '/' + id;
        console.log('URL', url);

        const response = await fetch(url, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        if (!response.ok) {
            throw new Error(`Failed to delete data: ${response.status} ${response.statusText}`);
        }
        // If the response contains JSON data, parse it
        // const data = await response.json().catch(() => null); //Use .catch() in case there's no JSON response
        return response;
    } catch (error) {
        console.error("Error in deleteData function: ", error);
        throw error; //Optionally re-throw the error for further handling
    }
}