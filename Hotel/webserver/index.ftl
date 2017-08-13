<!DOCTYPE html>
<html>
  <head>
      <title>Hotel</title>
      <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, minimal-ui">
      <style>
        body { margin: 0 !important }
        .targetText{
        	font-family: sans-serif;
		    font-weight: bolder;
		    font-size: 50px;
		    text-align: center;
        }
        .target{
    		display: none; 
    		width:50%; 
    		height:200px; 
    		float:right;
    		cursor: pointer;
    	}
    	.color1{
    		background: aliceblue;
    	}
    	.color2{
    		background: aquamarine;
    	}
      </style>
  </head>
  <body>
    <script>
      // Accesses the system used to send events
    	var system = parent.system;

      // Sends a monitor event to the flow. This triggers no action for now, but is a good practice.
    	system.sendEvent("monitor.game.connect", {});

      // Event Listener
    	system.onEvent = function (name, params) {
	        if (name == "action.game.start") {
	          targets = document.getElementsByClassName("target");
	          for (var i = 0; i < targets.length; i ++) {
	            targets[i].style.display = 'block';
	          }
	        }
    	}

      // Function to send the clicked target name to Furhat
		function targetClick(item) {
		  system.sendEvent("action.game.targetClick", {
		    target: item.getAttribute("item-id")
		  });
		}

    </script>
	
	<div style="width:100%">
		<p class="targetText">Hotel Skill Interface</p>
	</div>
    <div class="target color1" item-id="target1" style="display: none; width:50%; height:200px; float:left" onclick="targetClick(this)">
    	<p class="targetText">Target 1</p>
    </div>
    <div class="target color2" item-id="target2" style="display: none; width:50%; height:200px; float:right" onclick="targetClick(this)">
    	<p class="targetText">Target 2</p>
    </div>
  </body>
</html>