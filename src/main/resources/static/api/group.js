function getGroups() {
    return request({
        url: '/group/list',
        method: 'get'
    });
}

function addGroup(data) {
    return request({
        url: '/group/add',
        method: 'post',
        data: data
    });
}

function updateGroup(data) {
    return request({
        url: '/group/update',
        method: 'put',
        data: data
    });
}

function deleteGroup(id) {
    return request({
        url: '/group/delete?id=' + id,
        method: 'delete'
    });
}

function getGroup(id) {
    return request({
        url: '/group/get/' + id,
        method: 'get'
    });
}