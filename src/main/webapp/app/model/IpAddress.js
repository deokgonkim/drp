Ext.define('DRP.model.IpAddress', {
    extend: 'Ext.data.Model',
    fields: [ 'id', 'ipAddress', 'macAddress', 'org', 'manager', 'owner', 'description' ],
    proxy: {
        type: 'ajax',
        url: 'data/ipaddresses.json',
        api: {
            update: 'data/ipaddress/update.json'
        },
        reader: {
            type: 'json',
            root: 'ipaddresses',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            allowSingle: false
        },
        afterRequest:function(request,success){
            if ( request.operation.success == false ) {
                Ext.Msg.alert('실패', '데이터 처리중 문제가 발생하였습니다.');
            }
        }
    }
});
