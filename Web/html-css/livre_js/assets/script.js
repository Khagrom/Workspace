/**
 * Affiche un chapitre selon son ID.
 * @param num l'ID du chapitre à afficher.
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
}

/**
 * Cette fonction a pour but d'analyser l'URL et d'afficher le bon chapitre selon l'ID dans l'URL.
 */
function display_default() {
    var chap = 1;
    var url = document.URL;
    var url_chap = url.match(/#(chap)?\d\d?/); // Retourne soit 'null' soit un tableau d'une cellule

    if (url_chap) {
        chap = url_chap[0].match(/\d\d?/); // La même !
        chap = parseInt(chap[0]);
    }
    display(chap);
}