/**
 * Created by ryrodrig on 12/13/2015.
 */
$(function() {



    //jQuery time
    var current_fs, next_fs, previous_fs; //fieldsets
    var left, opacity, scale; //fieldset properties which we will animate
    var animating; //flag to prevent quick multi-click glitches


    var mandatoryFields = {
        fieldset1 : ["wwsidinput","requestedDateInput","creatorRMInput","requestorrminput","closuredateinput","owningrminput"],
        fieldset2 : [],
        fieldset3 : []
    };

    // $('.wwsidtooltip').tooltip();

    function addAlert(resource,message) {
        $(resource).append(
            '<div class="alert alert-danger fade in">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '&times;</button>' + message + '</div>');
    }

    function emptyFieldCheck(resource,spanresource,alertresource,alertmessage) {
        $(alertresource).empty();
        var inp = $(resource).val();
        if(jQuery.trim(inp).length > 0) {
            $(resource).parent().removeClass("has-error has-feedback");
            $(spanresource).removeClass("glyphicon glyphicon-remove-circle form-control-feedback");
            $(resource).parent().addClass("has-success has-feedback");
            $(spanresource).addClass("glyphicon glyphicon-ok-circle form-control-feedback");
            return false;
        } else {
            $(resource).parent().removeClass("has-success has-feedback");
            $(spanresource).removeClass("glyphicon glyphicon-ok-circle form-control-feedback");
            $(resource).parent().addClass("has-error has-feedback");
            $(spanresource).addClass("glyphicon glyphicon-remove-circle form-control-feedback");
            addAlert(alertresource,alertmessage);
            return true;
        }
    }

    $("#wwsidinput").blur(function() {
        emptyFieldCheck(this,'#validatewwsidinput','#wwsidinputalerts','WWSID field cannot be empty!!!');
    });

    $("#requestedDateInput").blur(function() {
        emptyFieldCheck(this,'#validaterequestedDateInput','#requestedDateInputalerts','RequestedDate field cannot be empty!!!');
    });

    $("#creatorRMInput").blur(function() {
        emptyFieldCheck(this,'#validatecreatorRMInput','#creatorRMInputalerts','Creator RM field cannot be empty!!!');
    });


    $("#requestorrminput").blur(function() {
        emptyFieldCheck(this,'#validaterequestorrminput','#requestorrminputalerts','Requestor RM cannot be empty!!!');
    });

    $("#closuredateinput").blur(function() {
        emptyFieldCheck(this,'#validateclosuredateinput','#closuredateinputalerts','Closure Date Field cannot be empty!!!');
    });

    $("#owningrminput").blur(function() {
        emptyFieldCheck(this,'#validateowningrminput','#owningrminputalerts','Owning RM cannot be empty!!!');
    });

    function validateFieldSet1Mandatory() {
        var wwsidEmpty = emptyFieldCheck('#wwsidinput','#validatewwsidinput','#wwsidinputalerts','WWSID field cannot be empty!!!');
        var requestDateEmpty = emptyFieldCheck('#requestedDateInput','#validaterequestedDateInput','#requestedDateInputalerts','RequestedDate field cannot be empty!!!');
        var creatorRMEmpty = emptyFieldCheck('#creatorRMInput','#validatecreatorRMInput','#creatorRMInputalerts','Creator RM field cannot be empty!!!');
        var requestorrmEmpty = emptyFieldCheck('#requestorrminput','#validaterequestorrminput','#requestorrminputalerts','Requestor RM cannot be empty!!!');
        var closuredateEmpty = emptyFieldCheck('#closuredateinput','#validateclosuredateinput','#closuredateinputalerts','Closure Date Field cannot be empty!!!');
        var owningrmEmpty = emptyFieldCheck('#owningrminput','#validateowningrminput','#owningrminputalerts','Owning RM cannot be empty!!!');

        return (wwsidEmpty || requestDateEmpty || creatorRMEmpty || requestorrmEmpty || closuredateEmpty || owningrmEmpty);

    }


    //jQuery(function() {
    //    function validateOnBlur() {
    //        alert("inside validateBlur");
    //        $('#requestedDateInput').trigger('blur');
    //    }
    //});(jQuery);

    function validateFieldsNextClick(fieldsetIndex) {

        if(fieldsetIndex==1) {
            return validateFieldSet1Mandatory();
        }
        //var continueNextPage = true;
        //alert(mandatoryFields['fieldset'+fieldsetIndex][0]);
        //var fieldSetMandatoryFields = mandatoryFields['fieldset'+fieldsetIndex];
        //$.each(fieldSetMandatoryFields,function(index,value) {
        //
        //    var fieldName = '#'+value;
        //    alert(fieldName);
        //    jQuery(function() {
        //        //$("#requestedDateInput").trigger("blur");
        //        validateOnBlur();
        //    });(jQuery);
        //    if($(fieldName).hasClass('has-error')) {
        //        continueNextPage = false;
        //    }
        //});
        //
        //return continueNextPage;
    }


    //(function($) {
    //    $.fn.validateNext = function() {
    //        alert('inside');
    //        this.trigger('blur');
    //    };
    //}(jQuery));

    $('#addMore').click(function() {
      $('#jobStatusDiv').removeClass('confirmationmodal');
        $('#jobStatusDiv').empty();
        location.reload();
    });




    $(".next").click(
        function() {
            if($(this).attr('id')=='reviewDetails') {
                $('#wwsidinputmodal').html($('#wwsidinput').val());
                $('#requestedDateInputmodal').html($('#requestedDateInput').val());
                $('#creatorRMInputmodal').html($('#creatorRMInput').val());
                $('#requestorrminputmodal').html($('#requestorrminput').val());
                $('#closuredateinputmodal').html($('#closuredateinput').val());
                $('#owningrminputmodal').html($('#owningrminput').val());
                $('#serviceLineIdmodal').html($('#serviceLineId option:selected').text());
                $('#rolenameidmodal').html($('#rolenameid option:selected').text());
                $('#serviceLineCapabilityIdmodal').html($('#serviceLineCapabilityId option:selected').text());
                $('#roleRequestorIdmodal').html($('#roleRequestorId option:selected').text());
                $('#accountIdmodal').html($('#accountId option:selected').text());
                $('#resourceRequirementInputmodal').html($('#resourceRequirementInput').val());
                $('#statusIdmodal').html($('#statusId option:selected').text());
                $('#jobStageIdmodal').html($('#jobStageId option:selected').text());
                $('#openDateInputmodal').html($('#openDateInput').val());
                $('#roleStartDateInputmodal').html($('#roleStartDateInput').val());
                $('#presenterDateInputmodal').html($('#presenterDateInput').val());
                $('#roleEndDateInputmodal').html($('#roleEndDateInput').val());
                $('#jobStageIdmodal').html($('#jobStageId option:selected').text());
                $('#employeeTypeIdmodal').html($('#employeeTypeId option:selected').text());
                $('#contractorRateInputmodal').html($('#contractorRateInput').val());
                $('#chargeOutRateInputmodal').html($('#chargeOutRateInput').val());
                $('#travelInputmodal').html($('#travelInput').val());
                $('#reqSpecificsInputmodal').html($('#reqSpecificsInput').val());
                return;
            }

            if (animating)
                return false;
            animating = true;
            current_fs = $(this).parent().parent();
            next_fs = $(this).parent().parent().next();


            var fieldsetIndex = ($("fieldset").index(current_fs) + 1);
            //$('#requestedDateInput').validateNext();
            // validatedata
             var hasFailures = validateFieldsNextClick(fieldsetIndex);
            //
            if(hasFailures) {
                animating = false;
                return;
            }

           //  alert($("fieldset").index(next_fs));

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
                        // 'animation': 'rotateCubeLeftOut 2s both ease'

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
                        //'animation': 'rotateCubeLeftIn 2s both ease'
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

            current_fs = $(this).parent().parent();
            previous_fs = $(this).parent().parent().prev();

            //current_fs = $(this).parent();
            //previous_fs = $(this).parent().prev();

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
