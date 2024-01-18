import axios from "axios";

export const Apiconexion = axios.create({
    baseURL: 'https://falling-night-44804.pktriot.net/',
    headers: {
        'Content-Type': 'application.json',
    },
});
