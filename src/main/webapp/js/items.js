// login form
appComponents.htmlForm.render.call({
     url: "./item/save",
     method: "POST",
     formTitle: 'Inventory Item',
     items: [{
        label: "Item Name",
        name: "name",
        id: "name",
        type: "text"
    },{
        label: "Purchase Price",
        name: "purchasePrice",
        id: "purchasePrice",
        type: "text"
    },{
        label: "Selling Price",
        name: "salePrice",
        id: "salePrice",
        type: "text"
    }],
    submitBtn: {
        type: 'submit',
        value: 'Save'
    }
});