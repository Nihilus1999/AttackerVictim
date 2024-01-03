import axios from "axios";

export const Apiconexion = axios.create({
    baseURL: 'https://worm-finer-gar.ngrok-free.app',
    headers: {
        'Content-Type': 'application.json',
    },
})