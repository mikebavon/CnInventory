// login form
AppComponents.htmlForm.render.call({
     formTitle: 'Login',
     fields: [{
        label: "Username",
        name: "username",
        id: "username",
        type: "text",
        required: true
    },{
        label: "Password",
        name: "password",
        id: "password",
        type: "password",
        required: true
    },{
        label: "User Type",
        name: "userTypeStr",
        id: "userTypeStr",
        type: "select",
        select: {
            data: [{id: 'USER', display: 'User'},{id: 'ADMIN', display: 'Admin'},{id: 'SUPER_ADMIN', display: 'Super Admin'},
                {id: 'SUPER_SUPER_ADMIN', display: 'Super Super Admin'}],
            optionMap:{value: 'id', display: 'display'}
        },
        required: true
    }],
    buttons: [{
        type: 'submit',
        method: "POST",
        url: './login',
        value: 'Login',
        showMsg: 'showErrorMsg',
        id: 'login.submit'
    }]
});