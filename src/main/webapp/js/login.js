// login form
appComponents.htmlForm.render.call({
     url: "./login",
     method: "POST",
     formTitle: 'Login',
     items: [{
        label: "Username",
        name: "username",
        id: "username",
        type: "text"
    },{
        label: "Password",
        name: "password",
        id: "password",
        type: "password"
    },{
        label: "User Type",
        name: "userTypeStr",
        id: "userTypeStr",
        type: "text"
    }],
    submitBtn: {
        type: 'submit',
        value: 'Login'
    }
});