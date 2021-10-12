// login form
var itemsCatComp = {
     url: "./itemcategory",
     method: "GET",
     tableTitle: 'Inventory Items Category',
     renderTo: 'componentRender',
     columns: [{
        header: "Name",
        dataIndex: "name",
        width: 47,
    }],
    form: {
         formTitle: 'Add Items Category',
         fields: [{
            label: "Name",
            name: "name",
            id: "item.category.name",
            type: "text",
            required: true
        }],
        buttons: [{
            type: 'submit',
            method: "POST",
            url: './itemcategory',
            value: 'Save',
            showMsg: 'showErrorMsg',
            id: 'item.category.submit',
            success: function(){
                AppComponents.htmlTable.render.apply(itemsCatComp);
            },
            failure: function(){
                AppComponents.htmlTable.render.apply(itemsCatComp);
            }
        }]
    },
    buttons: [{
        label: 'Add',
        id: 'item.category.add',
        handler: function(){
            // login form
            AppComponents.htmlForm.render.call(itemsCatComp.form);
        }
    }]
};