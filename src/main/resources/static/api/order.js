function getOrders() {
    return request({
        url: '/order/list',
        method: 'get'
    });
}

function addOrder(data) {
    return request({
        url: '/order/add',
        method: 'post',
        data: data
    });
}

function updateOrder(data) {
    return request({
        url: '/order/update',
        method: 'put',
        data: data
    });
}

function deleteOrder(id) {
    return request({
        url: '/order/delete?id=' + id,
        method: 'delete'
    });
}

function getOrder(data) {
    return request({
        url: '/order/get',
        method: 'post',
        data: data
    });
}

function getOrderById(id) {
    return request({
        url: '/order/getById?id=' + id,
        method: 'get'
    });
}