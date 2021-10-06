var appComponents = {
    htmlForm:{
        render: function(){
            let me = this;
            let formToRender = '<h2>' + me.formTitle + '</h2>';

            formToRender += '<form action="' + me.url + '" method="' + me.method + '">';

            me.items.forEach(item=>{
                formToRender += '<label for="' + item.id +'">' + item.label + ':</label><br>'
                 +'<input type="' + item.type + '" id="' + item.id +'" name="' + item.name + '"><br>';
            });

            formToRender += '<input type="' + me.submitBtn.type + '" value="' + me.submitBtn.value + '"></form>';

            document.getElementById('componentRender').innerHTML = formToRender;

        }
    },
    htmlTable: function(){
       var ajaxReq = new XMLHttpRequest();
       ajaxReq.onreadystatechange = function(){
           if (ajaxReq.readyState == XMLHttpRequest.DONE){
            if (ajaxReq.status == 200)
               document.getElementById("showItems").innerHTML = ajaxReq.responseText;
           }
       }

       ajaxReq.open('get','item/list', false);
       ajaxReq.send();

   }
};



