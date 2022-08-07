Ext.define('DRP.view.HardwareSearchPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.hardwaresearchpanel',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    border: false,
    //store: 'Hardwares',
    items: [{
        border: false,
        layout: 'fit',
        title: '검색조건',
        items: [{
            border: false,
            xtype: 'form',
            layout: 'column',
            padding: 5,
            items: [{
                xtype: 'combo',
                name: 'type',
                fieldLabel: '종류'
            },{
                xtype: 'textfield',
                name: 'manufacturer',
                fieldLabel: '제조사'
            },{
                xtype: 'textfield',
                name: 'modelName',
                fieldLabel: '모델명'
            },{
                xtype: 'combo',
                name: 'owner',
                fieldLabel: '사용자',
                store: 'Users',
                displayField: 'displayName',
                valueField: 'dn'
            }],
            buttons: [{
                xtype: 'button',
                text: '검색'
            }]
        }]
     }, {
        title: '검색결과',
        xtype: 'grid',
        layout: 'fit',
        flex: 1,
        columns: [{
            header: '종류',
            dataIndex: 'hardwareType',
            flex: 1
        }, {
            header: '제조사',
            dataIndex: 'manufacturer',
            flex: 1
        }, {
            header: '제품명(모델명)',
            dataIndex: 'modelName',
            flex: 1
        }, {
            header: '식별번호(씨리얼)',
            dataIndex: 'serialNumber',
            flex: 1
        }, {
            header: '사용자',
            dataIndex: 'owner',
            flex: 1
        }, {
            header: '비고',
            dataIndex: 'description',
            flex: 1
        }]
    }]
});