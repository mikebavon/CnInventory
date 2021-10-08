var AppComponents = {
    htmlForm:{
        render: function(){
            let me = this;
            let formToRender = '<h2>' + me.formTitle + '</h2>';

            formToRender += '<form>';

            me.fields.forEach(field=>{
                formToRender += '<label for="' + field.id +'">' + field.label
                    + (field.required?'<span style="color: red;">*</span>':'') + ':</label><br>'
                    +'<input type="' + field.type + '" id="' + field.id +'" name="' + field.name + '"><br>';
            });

            me.buttons.forEach(btn=>{
                formToRender += '<input type="' + btn.type + '" value="' + btn.value + '" id="' + btn.id + '"></form>';
            });

            document.getElementById('componentRender').innerHTML = formToRender;

            me.buttons.forEach(btn=>{
                document.getElementById(btn.id).addEventListener("click",  event=>{
                    event.preventDefault();
                    me.url = btn.url;
                    me.method = btn.method;
                    me.showMsg = btn.showMsg;
                    AppComponents.htmlForm.submit.apply(me);

                });
            });

        },
        submit: function(){
            let me = this;

            let submitData = '';

            let submitForm = true;
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

            var ajaxReq = new XMLHttpRequest();
            ajaxReq.onreadystatechange = function(){
               if (ajaxReq.readyState == XMLHttpRequest.DONE){
                if (ajaxReq.status == 200){
                        let reqRes = eval('(' + ajaxReq.responseText + ')');

                        if (reqRes.loginError)
                            document.getElementById(me.showMsg).innerHTML = reqRes.loginErrorMsg;
                        else if (reqRes.redirectPage)
                            location.href = reqRes.redirectPage;

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

            let me = this;
            let tableToRender = '<h2>' + me.tableTitle + '</h2>';

            me.buttons.forEach(btn=>{
                tableToRender += '<button type="button" id="' + btn.id + '">' + btn.label + '</button><br/>';
            });

            tableToRender += '<table>';

            let tableColGroup = '<colgroup>';
            let tableHeaders = '<thead><tr>';

            me.columns.forEach(col=>{
                tableColGroup += '<col span="' + (col.span?col.span: 1) + '" style="'+ (col.width? 'width:' + col.width + '%;': '') + '">';
                tableHeaders += '<th>' + col.header + '</th>';

            });

            tableColGroup += '</colgroup>';
            tableHeaders += '</tr></thead>';

            tableToRender += tableColGroup + tableHeaders;

            tableToRender += '<tbody>';

            var ajaxReq = new XMLHttpRequest();
            ajaxReq.onreadystatechange = function(){
               if (ajaxReq.readyState == XMLHttpRequest.DONE){
                if (ajaxReq.status == 200){
                        let reqRes = eval('(' + ajaxReq.responseText + ')');
                        reqRes.list.forEach(row=>{
                            tableToRender += '<tr>';
                            me.columns.forEach(col=>{
                                tableToRender += '<td>' + row[col.dataIndex] + '</td>';
                            });
                            tableToRender += '</tr>';

                        });

                        tableToRender += '</tbody>'

                        document.getElementById(me.renderTo).innerHTML = tableToRender;
                   }
               }
            }

            ajaxReq.open(me.method, me.url, false);
            ajaxReq.send();

        }
    }
};



