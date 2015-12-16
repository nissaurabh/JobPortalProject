/**
 * Created by ryrodrig on 12/13/2015.
 */
$(function() {

    //jQuery time
    var current_fs, next_fs, previous_fs; //fieldsets
    var left, opacity, scale; //fieldset properties which we will animate
    var animating; //flag to prevent quick multi-click glitches

    $(".next").click(
        function() {

            if (animating)
                return false;
            animating = true;

            current_fs = $(this).parent();
            next_fs = $(this).parent().next();

            //activate next step on progressbar using the index of next_fs
            $("#progressbar li").eq($("fieldset").index(next_fs))
                .addClass("active");

            //show the next fieldset
            next_fs.show();
            //hide the current fieldset with style
            current_fs.animate({
                opacity : 0
                // 'animation': 'rotateRoomTopOut 2s'
            }, {
                step : function(now, mx) {
                    //as the opacity of current_fs reduces to 0 - stored in "now"
                    //1. scale current_fs down to 80%
                    scale = 1 - (1 - now) * 0.2;
                    //2. bring next_fs from the right(50%)
                    left = (now * 50) + "%";
                    //3. increase opacity of next_fs to 1 as it moves in
                    opacity = 1 - now;
                    current_fs.css({
                        // 'transform' : 'scale(' + scale + ')',
                        'transform-origin': '50% 100%',
                        'animation': 'rotateRoomTopOut 2s both ease'
                        // 'transform' : 'perspective(500px) translateX(1px) translateZ(0px) rotateY(0deg)',
                        //'animation': 'rotateRoomRightIn 2s',
                        //'transform-origin': '100% 50%'
                       // '-webkit-animation': 'rotateRoomRightIn .8s both ease',
                       // 'animation': 'rotateRoomRightIn .8s both ease'
                    });
                    next_fs.css({

                        'left' : left,
                        'opacity' : opacity,
                        'transform-origin': '50% 0%',
                        'animation': 'rotateRoomTopIn 2s both ease'
                    });
                },
                duration : 800,
                complete : function() {
                    current_fs.hide();
                    animating = false;

                },
                //this comes from the custom easing plugin
                // easing : 'easeOutBounce'
            });
        });

    $(".previous").click(
        function() {
            if (animating)
                return false;
            animating = true;

            current_fs = $(this).parent();
            previous_fs = $(this).parent().prev();

            //de-activate current step on progressbar
            $("#progressbar li").eq($("fieldset").index(current_fs))
                .removeClass("active");

            //show the previous fieldset
            previous_fs.show();
            //hide the current fieldset with style
            current_fs.animate({

                opacity : 0
                // 'animation': 'rotateRoomTopOut 2s'
            }, {
                step : function(now, mx) {
                    //as the opacity of current_fs reduces to 0 - stored in "now"
                    //1. scale previous_fs from 80% to 100%
                    scale = 0.8 + (1 - now) * 0.2;
                    //2. take current_fs to the right(50%) - from 0%
                    left = ((1 - now) * 50) + "%";
                    //3. increase opacity of previous_fs to 1 as it moves in
                    opacity = 1 - now;
                    current_fs.css({
                        'transform-origin': '50% 0%',
                        'animation': 'rotateRoomBottomOut 2s both ease'
                       // 'left' : left
                    });
                    previous_fs.css({
                       // 'transform' : 'scale(' + scale + ')',
                        'transform-origin': '50% 100%',
                        'animation': 'rotateRoomBottomIn 2s both ease',
                        'opacity' : opacity
                    });
                },
                duration : 800,
                complete : function() {
                    current_fs.hide();
                    animating = false;
                },
                //this comes from the custom easing plugin
                // easing : 'easeInOutBack'
            });
        });

    $(".submit").click(function() {
        return false;
    });

});
