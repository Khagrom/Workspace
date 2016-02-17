/**
 * Displays the given chapter ID.
 * @param num the chapter ID to display.
 */
function display(num) {
    var sections = document.querySelectorAll("body > section");

    for (var i = 0; i < sections.length; i++) {
        var type = 'none';
        if (i + 1 == num) {
            type = 'block';
        }
        var chapter = "chap";
        var chapterSection = document.getElementById(chapter + (i+1) );
        chapterSection.style.display = type;

    }

    /*var steps = document.querySelectorAll('.step');
     for (var i = 0; i < steps.length; i++) {
     var type = 'none';
     if (i + 1 == num) {
     type = 'block';
     }
     steps[i].style.display = type;
     }*/
}

/**
 * This function intends to safely parse the URL and display the correct step given the ID in the URL.
 */
function display_default() {
    var chap = 1;
    var url = document.URL;
    var url_chap = url.match(/#(chap)?\d\d?/); // Either returns null or a single-cell array (first match)

    if (url_chap) {
        chap = url_chap[0].match(/\d\d?/); // Same as previous
        chap = parseInt(chap[0]);
    }
    display(chap);
}