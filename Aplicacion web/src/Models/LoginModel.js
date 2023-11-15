export default class UserModel {
    constructor() {
        this.username = "";
        this.password = "";
    }

    async login() {
        // const response = await fetch('/url/', {
        //     method: 'POST',
        //     headers: {
        //         'Content-Type': 'application/json'
        //     },
        //     body: JSON.stringify({
        //         username: this.username,
        //         password: this.password
        //     })
        // });

        //const data = await response.json();
        const data = {
            username: 'iagovisk',
            password: 'pedro123',
            success: true
        }

        return data;
    }
}