// login form
var itemsCatComp = {
     url: "./itemcategory",
     method: "GET",
     tableTitle: 'Inventory Items Category',
     renderTo: 'componentRender',
     id: 'itemCategoryTableId',
     columns: [{
        header: "Name",
        dataIndex: "name",
        width: 80,
    },{
        dataIndex: "id",
        link: true,
        linkLabel: 'View',
        width: 15,
        linkHandler: function(categoryId){
            itemsComp.filterQuery = '&categoryId=' + categoryId;
            AppComponents.htmlTable.render.apply(itemsComp);
        }
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
            AppComponents.htmlForm.render.call(itemsCatComp.form);
        }
    },{
        label: 'View Items',
        id: 'item.category.viewitems',
        handler: function(){
            AppComponents.htmlTable.render.apply(itemsComp);
        }
    }]
};