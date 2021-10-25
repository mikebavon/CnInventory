var supplierComp = {
     url: "./supplier",
     method: "GET",
     tableTitle: 'Supplier',
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
         formTitle: 'Add Supplier',
         fields: [{
            label: "Name",
            name: "name",
            id: "supplier.name",
            type: "text",
            required: true
        },{
            label: "Phone No",
            name: "phoneNo",
            id: "supplier.phoneNo",
            type: "text",
            required: true
        },{
            label: "Address",
            name: "address",
            id: "supplier.address",
            type: "text",
            required: true
        }],
        buttons: [{
            type: 'submit',
            method: "POST",
            url: './supplier',
            value: 'Save',
            showMsg: 'showErrorMsg',
            id: 'supplier.submit',
            success: function(){
                AppComponents.htmlTable.render.apply(supplierComp);
            },
            failure: function(){
                AppComponents.htmlTable.render.apply(supplierComp);
            }
        }]
    },
    buttons: [{
        label: 'Add',
        id: 'supplier.add',
        handler: function(){
            AppComponents.htmlForm.render.call(supplierComp.form);
        }
    }]
};