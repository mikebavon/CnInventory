var AppComponents = {
    htmlForm:{
        render: function(){
            /* this method renders dynamic html form */

            //declaring this object to me, so that we can reference to it, even when we are not within this.
            let me = this;

            //html to render form
            let formToRender = '<h2>' + me.formTitle + '</h2>';

            formToRender += '<form>';

            //loop through the form fields and construct form input fields in html
            me.fields.forEach(field=>{
                formToRender += '<label for="' + field.id +'">' + field.label
                    + (field.required?'<span style="color: red;">*</span>':'') + ':</label><br>'
                    +'<input type="' + field.type + '" id="' + field.id +'" name="' + field.name + '"><br>';
            });

            formToRender += '<br/><br/>';

            //add buttons to form render
            me.buttons.forEach(btn=>{
                formToRender += '<input type="' + btn.type + '" value="' + btn.value + '" id="' + btn.id + '"></form>';
            });

            //render form in html div with id 'componentRender'
            document.getElementById('componentRender').innerHTML = formToRender;

            //loop through the buttons again and add event listeners, modifying url, method, showMsg, success function, failure fucntion
            me.buttons.forEach(btn=>{
                document.getElementById(btn.id).addEventListener("click",  event=>{
                    event.preventDefault();

                    me.url = btn.url;
                    me.method = btn.method;
                    me.showMsg = btn.showMsg;
                    me.success = btn.success; // will execute if saving is success
                    me.failure = btn.failure; //will execute if saving is failure

                    AppComponents.htmlForm.submit.apply(me);

                });
            });

        },
        submit: function(){
            /* this method submit a form through ajax */

            //declaring this object to me, so that we can reference to it, even when we are not within this.
            let me = this;

            //data to be submitted will be populated in this variable
            let submitData = '';

            //flag to check if form is clean to be submitted
            let submitForm = true;

            //loop through the form to be submitted and collect the values while populating the submitForm variable
            me.fields.forEach(field=>{
                let fieldVal = document.getElementById(field.id).value;
                if (field.required === true && !fieldVal)
                    submitForm = false;

                submitData += encodeURIComponent(field.name) + '=' + encodeURIComponent(fieldVal) + '&';

            });

            if (!submitForm){
                document.getElementById(me.showMsg).innerHTML = 'Please Enter All Required Fields(*)';
                return;
            }

            //ajax component
            var ajaxReq = new XMLHttpRequest();
            ajaxReq.onreadystatechange = function(){
               if (ajaxReq.readyState == XMLHttpRequest.DONE){
                if (ajaxReq.status == 200){
                        let reqRes = eval('(' + ajaxReq.responseText + ')');
                        console.log(me.success);
                        console.log(me.failure);

                        if (reqRes.loginError)
                            document.getElementById(me.showMsg).innerHTML = reqRes.loginErrorMsg;
                        else if (reqRes.redirectPage)
                            location.href = reqRes.redirectPage;
                        else if (reqRes.success)
                            me.success();
                        else if (reqRes.failure)
                            me.failure();
                   }
               }
            }

            ajaxReq.open(me.method, me.url, false);
            ajaxReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            ajaxReq.send(submitData);

        }
    },
    htmlTable: {
        render: function(){
            /* this method render html page */

            let me = this;
            let tableToRender = '<h2>' + me.tableTitle + '</h2>';

            me.buttons.forEach(btn=>{
                tableToRender += '<button class="app-btn green-btn" type="button" id="' + btn.id + '">' + btn.label + '</button>';
            });

            tableToRender += '<br/><br/><table>';

            let tableColGroup = '<colgroup>';
            let tableHeaders = '<thead><tr>';

            tableColGroup += '<col span="1" style="width: 3%">';
            tableHeaders += '<th></th>';

            me.columns.forEach(col=>{
                tableColGroup += '<col span="' + (col.span?col.span: 1) + '" style="'+ (col.width? 'width:' + col.width + '%;': '') + '">';
                tableHeaders += '<th>' + col.header + '</th>';

            });

            tableColGroup += '</colgroup>';
            tableHeaders += '</tr></thead>';

            tableToRender += tableColGroup + tableHeaders;

            tableToRender += '<tbody>';

            //load page from html
            var ajaxReq = new XMLHttpRequest();
            ajaxReq.onreadystatechange = function(){
               if (ajaxReq.readyState == XMLHttpRequest.DONE){
                if (ajaxReq.status == 200){
                        let reqRes = eval('(' + ajaxReq.responseText + ')');
                        reqRes.list.forEach(row=>{
                            tableToRender += '<tr><td><input type="checkbox" name="name1" />&nbsp;</td>';

                            me.columns.forEach(col=>{
                                tableToRender += '<td>' + row[col.dataIndex] + '</td>';
                            });
                            tableToRender += '</tr>';

                        });

                   }
               }
            }

            ajaxReq.open(me.method, me.url, false);
            ajaxReq.send();

            tableToRender += '</tbody>'
            document.getElementById(me.renderTo).innerHTML = tableToRender;

            me.buttons.forEach(btn=>{
                document.getElementById(btn.id).addEventListener("click", btn.handler);
            });

        }
    },
    htmlToNavBar: {
        render: function(){
            let me = this;

            let topNavToolBar = '';

            me.links.forEach(link=>{
                topNavToolBar += '<a class="' + link.class + '" id="' + link.id + '" href="#">' + link.label + '</a>';
            });

            document.getElementById(me.renderTo).innerHTML = topNavToolBar;

            me.links.forEach(link=>{
                document.getElementById(link.id).addEventListener("click", link.handler);
            });

        },
        changeStyle: function(linkId){
            let me = this;
            console.log(me);
            console.log(linkId);

            me.links.forEach(link=>{
                if (link.id === linkId){
                    document.getElementById(linkId).classList.add("active");

                }else{
                   document.getElementById(linkId).classList.remove("active");

               }
            });
        }
    }
};



