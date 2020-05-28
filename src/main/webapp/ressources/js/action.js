function editCategorie(){
	var sel = document.getElementById('selectCat');
	
	var opt = sel.options[sel.selectedIndex];
	
	if(opt.text!="Catégorie"){
	
		var url = '/Filmotheque/app/vueModifierCategorie?id='+sel.selectedIndex+'&label='+opt.text;
	
		window.location.href = url;
	}

}