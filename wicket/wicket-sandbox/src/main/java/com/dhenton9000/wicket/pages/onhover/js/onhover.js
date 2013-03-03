$(document).ready(function() {
 
    var changeTooltipPosition = function(event) {
        var tooltipX = event.pageX - 8;
        var tooltipY = event.pageY + 8;
        $('div.tooltip').css({
            top: tooltipY, 
            left: tooltipX
        });
    };
 
    //	var showTooltip = function(event) {
    //	  $('div.tooltip').remove();
    //	  $('<div class="tooltip">I\' am tooltips! tooltips! tooltips! :)</div>')
    //            .appendTo('body');
    //	  changeTooltipPosition(event);
    //	};
        
        
    var showTooltip = function(event) {
        tText = $(this).attr('toolTipText');
        if (tText.toString().length > 0)
        { 
            $('div.tooltip').remove();
            $('<div id="hoverMessageDivBlock" class="tooltip">' + tText +'</div>')
            .appendTo('body');
            changeTooltipPosition(event);
        }
        
    };
        
        
 
    var hideTooltip = function() {
        $('div.tooltip').remove();
    };
 
    $("span#hoverItem").bind({
        mousemove : changeTooltipPosition,
        mouseenter : showTooltip,
        mouseleave: hideTooltip
    });
});