var customerComp = {
     url: "./customer",
     method: "GET",
     tableTitle: 'Customers',
     renderTo: 'componentRender',
     columns: [{
        header: "Name",
        dataIndex: "name",
        width: 37,
    },{
        header: "Phone No",
        dataIndex: "phoneNo",
        width: 30,
    },{
        header: "Address",
        dataIndex: "address",
        width: 30,
    }],
    form: {
         formTitle: 'Add Customer',
         fields: [{
            label: "Name",
            name: "name",
            id: "customer.name",
            type: "text",
            required: true
        },{
            label: "Phone No",
            name: "phoneNo",
            id: "customer.phoneNo",
            type: "text",
            required: true
        },{
            label: "Address",
            name: "address",
            id: "customer.address",
            type: "text",
            required: true
        }],
        buttons: [{
            type: 'submit',
            method: "POST",
            url: './customer',
            value: 'Save',
            showMsg: 'showErrorMsg',
            id: 'customer.submit',
            success: function(){
                AppComponents.htmlTable.render.apply(customerComp);
            },
            failure: function(){
                AppComponents.htmlTable.render.apply(customerComp);
            }
        }]
    },
    buttons: [{
        label: 'Add',
        id: 'customer.add',
        handler: function(){
            AppComponents.htmlForm.render.call(customerComp.form);
        }
    }]
};