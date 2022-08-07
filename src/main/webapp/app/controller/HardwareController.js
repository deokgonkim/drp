Ext.define('DRP.controller.HardwareController', {
    extend: 'Ext.app.Controller',
    init: function() {
        this.control({
            'hardwaresearchpanel': {
                //render: this.onLoad
            }
        });
        console.log('Initialized HardwareController!');
    },
    refs: [{
        selector: 'viewport > #tabPanel > hardwaresearchpanel',
        ref: 'hardwaresearchpanel'
    }],
    stores: [  ],
    models: [ 'Hardware' ],
    views: [ 'HardwareSearchPanel' ]
});