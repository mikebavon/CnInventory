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
        type: "text"
    }],
    buttons: [{
        type: 'submit',
        method: "POST",
        url: './login',
        value: 'Login',
        showMsg: 'showErrorMsg',
        id: 'login.submit'
    },{
        type: 'submit',
        method: "POST",
        url: './forgotpwd',
        value: 'Forgot Password',
        showMsg: 'showErrorMsg',
        id: 'login.forgotpwd'
    },{
        type: 'submit',
        method: "POST",
        url: './register',
        value: 'Register',
        showMsg: 'showErrorMsg',
        id: 'login.register'
    }]
});