Ext.define('DRP.view.SoftwareSearchPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.softwaresearchpanel',
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
                name: 'purchased',
                fieldLabel: '구매'
            },{
                xtype: 'textfield',
                name: 'manufacturer',
                fieldLabel: '제조사'
            },{
                xtype: 'textfield',
                name: 'programName',
                fieldLabel: '제품명'
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
            header: '구매',
            dataIndex: 'purchased',
            flex: 1
        }, {
            header: '제조사',
            dataIndex: 'manufacturer',
            flex: 1
        }, {
            header: '제품명',
            dataIndex: 'programName',
            flex: 1
        }, {
            header: '버전',
            dataIndex: 'version',
            flex: 1
        }, {
            header: '카피수',
            dataIndex: 'copys',
            flex: 1
        }, {
            header: '사용카피수',
            dataIndex: 'copysUsed',
            flex: 1
        }, {
            header: '비고',
            dataIndex: 'description',
            flex: 1
        }]
    }]
});