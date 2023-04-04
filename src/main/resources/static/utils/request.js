(function win(win) {
    const BASE_URL = "http://localhost";
    const service = axios.create({
        baseURL: BASE_URL,
        timeout: 10000,
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
        }
    });

    service.interceptors.request.use(
        config => {
            return config;
        },
        error => {
            return Promise.reject(error);
        }
    );
    service.interceptors.response.use(
        response => {
            const res = response.data;
            if (res.flag) {
                if(res.msg){
                    window.ELEMENT.Message({
                        message: res.msg,
                        type: 'success',
                        duration: 5 * 1000
                    });
                }

            }else {
                window.ELEMENT.Message({
                    message: res.msg,
                    type: 'error',
                    duration: 5 * 1000
                });
            }
            return res;
        }
    );
    win.request=service;
})(window);
