var warehouseComp = {
     url: "./warehouse",
     method: "GET",
     tableTitle: 'Warehouse',
     renderTo: 'componentRender',
     columns: [{
        header: "Name",
        dataIndex: "name",
        width: 37,
    },{
        header: "Location",
        dataIndex: "location",
        width: 30,
    },{
        dataIndex: "id",
        link: true,
        linkLabel: 'View Items',
        width: 15,
        linkHandler: function(warehouseId){
            itemsComp.filterQuery = '&warehouseId=' + warehouseId;
            AppComponents.htmlTable.render.apply(itemsComp);
        }
    }],
    form: {
         formTitle: 'Add Warehouse',
         fields: [{
            label: "Name",
            name: "name",
            id: "warehouse.name",
            type: "text",
            required: true
        },{
            label: "Location",
            name: "location",
            id: "warehouse.location",
            type: "text",
            required: true
        }],
        buttons: [{
            type: 'submit',
            method: "POST",
            url: './warehouse',
            value: 'Save',
            showMsg: 'showErrorMsg',
            id: 'warehouse.submit',
            success: function(){
                AppComponents.htmlTable.render.apply(warehouseComp);
            },
            failure: function(){
                AppComponents.htmlTable.render.apply(warehouseComp);
            }
        }]
    },
    buttons: [{
        label: 'Add',
        id: 'warehouse.add',
        handler: function(){
            AppComponents.htmlForm.render.call(warehouseComp.form);
        }
    }]
};