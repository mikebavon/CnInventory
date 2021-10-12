// login form
let appNavBarLinks = {
     renderTo: "comp-topnav",
     links: [{
        label: "Items Category",
        id: "app.link.itemcategory",
        handler: function(){
            let me = this;

            AppComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            AppComponents.htmlTable.render.apply(itemsCatComp);

        }
    },{
        label: "Items",
        id: "app.link.item",
        handler: function(){
            let me = this;

            AppComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            AppComponents.htmlTable.render.apply(itemsComp);

        }
    },{
        label: "Customers",
        id: "app.link.customers",
        handler: function(){

        }
    },{
        label: "Suppliers",
        id: "app.link.suppliers",
        handler: function(){

        }
    },{
        label: "Orders",
        id: "app.link.orders",
        handler: function(){

        }
    }]
};

AppComponents.htmlToNavBar.render.call(appNavBarLinks);