// login form
let appNavBarLinks = {
     renderTo: "comp-topnav",
     links: [{
        label: "Items",
        id: "app.link.item",
        handler: function(){
            let me = this;

            AppComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            AppComponents.htmlTable.render.apply(itemsComp);

        }
    },{
        label: "Items Category",
        id: "app.link.itemcategory",
        handler: function(){

        }
    },{
        label: "Customers",
        id: "app.link.customers",
        handler: function(){

        }
    }]
};

AppComponents.htmlToNavBar.render.call(appNavBarLinks);