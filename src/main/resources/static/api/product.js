function getProducts() {
    return request({
        url: '/product/list',
        method: 'get'
    });
}

function addProduct(data) {
    return request({
        url: '/product/add',
        method: 'post',
        data: data
    });
}

function updateProduct(data) {
    return request({
        url: '/product/update',
        method: 'put',
        data: data
    });
}

function deleteProduct(id) {
    return request({
        url: '/product/delete?id=' + id,
        method: 'delete'
    });
}

function getProduct(params) {
    return request({
        url: '/product/get',
        method: 'get',
        params: params
    });
}
function getProductById(id) {
    return request({
        url: '/product/getById?id=' + id,
        method: 'get'
    });
}