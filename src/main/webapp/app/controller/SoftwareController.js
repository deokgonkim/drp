Ext.define('DRP.controller.SoftwareController', {
    extend: 'Ext.app.Controller',
    init: function() {
        this.control({
            /*'softwaresearchpanel': {
                render: this.onLoad
            }*/
        });
        console.log('Initialized SoftwareController!');
    },
    refs: [{
        selector: 'viewport > #tabPanel > softwaresearchpanel',
        ref: 'softwaresearchpanel'
    }],
    stores: [  ],
    models: [  ],
    views: [ 'SoftwareSearchPanel' ]
});