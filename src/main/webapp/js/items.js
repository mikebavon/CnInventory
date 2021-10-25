// login form
var itemsComp = {
     url: "./item/list",
     method: "GET",
     tableTitle: 'Inventory Items',
     renderTo: 'componentRender',
     columns: [{
        header: "Name",
        dataIndex: "name",
        width: 47,
    },{
        header: "Purchase Price",
        dataIndex: "purchasePrice",
        width: 25
    },{
        header: "Sale Price",
        dataIndex: "salePrice",
        width: 25
    }],
    form: {
         formTitle: 'Add Item',
         fields: [{
            label: "Category",
            name: "categoryId",
            id: "item.categoryId",
            type: "select",
            select: {
                url: './itemcategory',
                optionMap:{value: 'id', display: 'name'}
            },
            required: true
        },{
            label: "Name",
            name: "name",
            id: "item.name",
            type: "text",
            required: true
        },{
            label: "Purchase Price",
            name: "purchasePrice",
            id: "item.purchasePrice",
            type: "text",
            required: true
        },{
            label: "Sale Price",
            name: "salePrice",
            id: "item.salePrice",
            type: "text",
            required: true
        },{
            label: "Warehouse",
            name: "warehouseId",
            id: "item.warehouseId",
            type: "select",
            select: {
                url: './warehouse',
                optionMap:{value: 'id', display: 'name'}
            },
            required: true
        }],
        buttons: [{
            type: 'submit',
            method: "POST",
            url: './item/save',
            value: 'Save',
            showMsg: 'showErrorMsg',
            id: 'item.submit',
            success: function(){
                AppComponents.htmlTable.render.apply(itemsComp);
            },
            failure: function(){
                AppComponents.htmlTable.render.apply(itemsComp);
            }
        }]
    },
    buttons: [{
        label: 'Add',
        id: 'item.add',
        handler: function(){
            // login form
            AppComponents.htmlForm.render.call(itemsComp.form);
        }
    }]
};