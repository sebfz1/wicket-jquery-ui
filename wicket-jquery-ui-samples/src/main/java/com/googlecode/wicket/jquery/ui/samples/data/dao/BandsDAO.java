package com.googlecode.wicket.jquery.ui.samples.data.dao;

import java.util.List;

import org.apache.wicket.util.lang.Generics;

import com.googlecode.wicket.jquery.ui.samples.data.bean.BandTreeNode;
import com.googlecode.wicket.jquery.ui.samples.data.bean.CountryTreeNode;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeNode;

public class BandsDAO
{
	private static BandsDAO instance = null;

	private final List<TreeNode<?>> list;

	public BandsDAO()
	{
		this.list = Generics.newArrayList();

		CountryTreeNode ar = new CountryTreeNode("Argentina");
		this.list.add(ar);
		CountryTreeNode au = new CountryTreeNode("Australia");
		this.list.add(au);
		CountryTreeNode ca = new CountryTreeNode("Canada");
		this.list.add(ca);
		CountryTreeNode dk = new CountryTreeNode("Denmark");
		this.list.add(dk);
		CountryTreeNode fi = new CountryTreeNode("Finland");
		this.list.add(fi);
		CountryTreeNode fr = new CountryTreeNode("France");
		this.list.add(fr);
		CountryTreeNode de = new CountryTreeNode("Germany");
		this.list.add(de);
		CountryTreeNode ie = new CountryTreeNode("Ireland");
		this.list.add(ie);
		CountryTreeNode it = new CountryTreeNode("Italy");
		this.list.add(it);
		CountryTreeNode jp = new CountryTreeNode("Japan");
		this.list.add(jp);
		CountryTreeNode nl = new CountryTreeNode("Netherlands");
		this.list.add(nl);
		CountryTreeNode pl = new CountryTreeNode("Poland");
		this.list.add(pl);
		CountryTreeNode za = new CountryTreeNode("South Africa");
		this.list.add(za);
		CountryTreeNode es = new CountryTreeNode("Spain");
		this.list.add(es);
		CountryTreeNode se = new CountryTreeNode("Sweden");
		this.list.add(se);
		CountryTreeNode ch = new CountryTreeNode("Switzerland");
		this.list.add(ch);
		CountryTreeNode uk = new CountryTreeNode("United Kingdom");
		this.list.add(uk);
		CountryTreeNode us = new CountryTreeNode("United States");
		this.list.add(us);

		this.list.add(new BandTreeNode(jp.getId(), "44 Magnum", "1977–1989, 2002–present"));
		this.list.add(new BandTreeNode(se.getId(), "220 Volt", "1979–present"));
		this.list.add(new BandTreeNode(uk.getId(), "A II Z", "1979-1982"));
		this.list.add(new BandTreeNode(au.getId(), "AC/DC", "1973–present"));
		this.list.add(new BandTreeNode(de.getId(), "Accept", "1976–1989, 1992–1997, 2004–2005, 2009–present"));
		this.list.add(new BandTreeNode(us.getId(), "Aerosmith", "1970–present"));
		this.list.add(new BandTreeNode(us.getId(), "Alice Cooper", "1968–present"));
		this.list.add(new BandTreeNode(us.getId(), "Angel", "1975–1981, 1987, 1998–present"));
		this.list.add(new BandTreeNode(es.getId(), "Ángeles del Infierno", "1978–present"));
		this.list.add(new BandTreeNode(au.getId(), "The Angels", "1974-2000, 2008–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Angel Witch", "1977-1982, 1984-1998, 2000–present"));
		this.list.add(new BandTreeNode(jp.getId(), "Anthem", "1980–1992, 2000–present"));
		this.list.add(new BandTreeNode(us.getId(), "Anthrax", "1981–present"));
		this.list.add(new BandTreeNode(us.getId(), "Avenged Sevenfold", "1999–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Anvil", "1978–present"));
		this.list.add(new BandTreeNode(ca.getId(), "April Wine", "1969-1986, 1992–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Armageddon", "1974–1976"));
		this.list.add(new BandTreeNode(uk.getId(), "Atomic Rooster", "1969–1975, 1980–1983"));
		this.list.add(new BandTreeNode(uk.getId(), "Atomkraft", "1979–1988, 2005"));
		this.list.add(new BandTreeNode(us.getId(), "Attila", "1969-1970"));
		this.list.add(new BandTreeNode(us.getId(), "Axe", "1979-1984, 1997-2004"));
		this.list.add(new BandTreeNode(uk.getId(), "Babe Ruth", "1970-1976, 2005–present"));
		this.list.add(new BandTreeNode(us.getId(), "Bang", "1970–1973, 2001–2004"));
		this.list.add(new BandTreeNode(us.getId(), "Barnabas", "1977-1986"));
		this.list.add(new BandTreeNode(es.getId(), "Barón Rojo", "1980–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Battleaxe", "1980–1988, 2010–present"));
		this.list.add(new BandTreeNode(uk.getId(), "The Beatles", "1960-1970"));
		this.list.add(new BandTreeNode(au.getId(), "Bengal Tigers", "1979–present"));
		this.list.add(new BandTreeNode(us.getId(), "Beowülf", "1981–1995, 2000–present"));
		this.list.add(new BandTreeNode(de.getId(), "Birth Control", "1966-1983, 1993-2014"));
		this.list.add(new BandTreeNode(us.getId(), "Bitch", "1980–present"));
		this.list.add(new BandTreeNode(us.getId(), "Black Death", "1977–present"));
		this.list.add(new BandTreeNode(us.getId(), "Black 'n Blue", "1981–1989, 1997, 2003, 2007–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Black Rose", "1980-1989, 2006–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Black Sabbath", "1968–2006, 2011–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Black Widow", "1966–1973, 2007–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Blitzkrieg", "1980–1981, 1984–1991, 1992–1994, 1996–1999, 2001–present"));
		this.list.add(new BandTreeNode(us.getId(), "Bloodrock", "1969–1975"));
		this.list.add(new BandTreeNode(us.getId(), "Blue Cheer", "1966–1972, 1974–1976, 1978–1979, 1984–1994, 1999–2009"));
		this.list.add(new BandTreeNode(us.getId(), "Blue Öyster Cult", "1967–present"));
		this.list.add(new BandTreeNode(nl.getId(), "Bodine", "1978-1984"));
		this.list.add(new BandTreeNode(au.getId(), "Boss", "1979-1986"));
		this.list.add(new BandTreeNode(jp.getId(), "Bow Wow", "1976–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Bronz", "1976-1985, 1999-2000, 2003–2005, 2010–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Edgar Broughton Band", "1968–2010"));
		this.list.add(new BandTreeNode(uk.getId(), "Budgie", "1967–present"));
		this.list.add(new BandTreeNode(au.getId(), "Buffalo", "1971–1977"));
		this.list.add(new BandTreeNode(it.getId(), "Bulldozer", "1980–1990, 2008–present"));
		this.list.add(new BandTreeNode(us.getId(), "Cactus", "1970–1972, 2006–present"));
		this.list.add(new BandTreeNode(us.getId(), "Captain Beyond", "1971-1973, 1976-1978, 1998-2003"));
		this.list.add(new BandTreeNode(uk.getId(), "Chateaux", "1981-1985"));
		this.list.add(new BandTreeNode(us.getId(), "Cirith Ungol", "1972–1992"));
		this.list.add(new BandTreeNode(uk.getId(), "Cloven Hoof", "1979–1990, 2000–present"));
		this.list.add(new BandTreeNode(us.getId(), "Coven", "1969–1975, 2007–2008"));
		this.list.add(new BandTreeNode(uk.getId(), "Cream", "1966–1969"));
		this.list.add(new BandTreeNode(us.getId(), "Crimson Glory", "1979–1992, 1998–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Crushed Butler", "1969-1971"));
		this.list.add(new BandTreeNode(us.getId(), "Dark Angel", "1981–1992, 2002–2005, 2013–present"));
		this.list.add(new BandTreeNode(it.getId(), "Death SS", "1977-1984, 1988–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Dedringer", "1977-1985"));
		this.list.add(new BandTreeNode(uk.getId(), "Deep Machine", "1979-1982, 2009–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Deep Purple", "1968-1976, 1984–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Def Leppard", "1977–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Demon", "1979–present"));
		this.list.add(new BandTreeNode(uk.getId(), "The Deviants", "1967–1969, 1978, 1984, 1996, 2002, 2011–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Diamond Head", "1976–1985, 1991–1994, 2002–present"));
		this.list.add(new BandTreeNode(us.getId(), "Dokken", "1978–1989, 1993–present"));
		this.list.add(new BandTreeNode(us.getId(), "Dust", "1969-1972"));
		this.list.add(new BandTreeNode(jp.getId(), "Earthshaker", "1978-1994, 1999–present"));
		this.list.add(new BandTreeNode(se.getId(), "Easy Action", "1981–1986, 2006–present"));
		this.list.add(new BandTreeNode(se.getId(), "E.F. Band", "1979-1986"));
		this.list.add(new BandTreeNode(de.getId(), "Electric Sun", "1978-1986"));
		this.list.add(new BandTreeNode(us.getId(), "Elf", "1967-1975"));
		this.list.add(new BandTreeNode(de.getId(), "Eloy", "1969-1984, 1988-present"));
		this.list.add(new BandTreeNode(uk.getId(), "Emerson, Lake & Palmer", "1970-1979, 1991-1998"));
		this.list.add(new BandTreeNode(uk.getId(), "Ethel the Frog", "1976-1980"));
		this.list.add(new BandTreeNode(se.getId(), "Europe", "1979–1992, 1999 (partial reunion), 2003–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Exciter", "1978–present"));
		this.list.add(new BandTreeNode(us.getId(), "Exodus", "1980–1993, 1997–1998, 2001–present"));
		this.list.add(new BandTreeNode(us.getId(), "Faith No More", "1979–1998, 2009–present"));
		this.list.add(new BandTreeNode(us.getId(), "Fallout", "1979-1982"));
		this.list.add(new BandTreeNode(uk.getId(), "Fist", "1978-1982, 2001–2006"));
		this.list.add(new BandTreeNode(us.getId(), "Flotsam and Jetsam", "1981–present"));
		this.list.add(new BandTreeNode(jp.getId(), "Flower Travellin' Band", "1968–1973, 2007–present"));
		this.list.add(new BandTreeNode(uk.getId(), "The Flying Hat Band", "1971–1974"));
		this.list.add(new BandTreeNode(us.getId(), "Gamma", "1978–1983, 2000"));
		this.list.add(new BandTreeNode(uk.getId(), "Genesis", "1967-1998, 2006–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Geordie", "1972–1980, 1982–1985, 2001"));
		this.list.add(new BandTreeNode(us.getId(), "GG Allin", "1972-1993"));
		this.list.add(new BandTreeNode(uk.getId(), "Gillan", "1978–1983"));
		this.list.add(new BandTreeNode(uk.getId(), "Girl", "1979-1982"));
		this.list.add(new BandTreeNode(uk.getId(), "Girlschool", "1978–present"));
		this.list.add(new BandTreeNode(us.getId(), "Grand Funk Railroad", "1968–1977, 1980–1983, 1996–present"));
		this.list.add(new BandTreeNode(de.getId(), "Grave Digger", "1980–1987, 1991–present"));
		this.list.add(new BandTreeNode(de.getId(), "Gravestone", "1977-1986"));
		this.list.add(new BandTreeNode(us.getId(), "Great White", "1977–2001, 2002–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Grim Reaper", "1979–1988, 2006–present"));
		this.list.add(new BandTreeNode(uk.getId(), "The Gun", "1967-1970"));
		this.list.add(new BandTreeNode(us.getId(), "Sammy Hagar", "1967–present"));
		this.list.add(new BandTreeNode(uk.getId(), "The Handsome Beasts", "1972–present"));
		this.list.add(new BandTreeNode(fi.getId(), "Hanoi Rocks", "1979–1985, 2001–2009"));
		this.list.add(new BandTreeNode(uk.getId(), "Hard Stuff", "1971–1973"));
		this.list.add(new BandTreeNode(uk.getId(), "Hawkwind", "1969–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Headpins", "1979–present"));
		this.list.add(new BandTreeNode(us.getId(), "Heart", "1973–present"));
		this.list.add(new BandTreeNode(au.getId(), "Heaven", "1980–2000"));
		this.list.add(new BandTreeNode(se.getId(), "Heavy Load", "1976–1985"));
		this.list.add(new BandTreeNode(uk.getId(), "Heavy Metal Kids", "1972-1985, 2002–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Helix", "1974–present"));
		this.list.add(new BandTreeNode(uk.getId(), "The Jimi Hendrix Experience", "1966–1970"));
		this.list.add(new BandTreeNode(uk.getId(), "High Tide", "1969–1970"));
		this.list.add(new BandTreeNode(fi.getId(), "HIM", "1991 - present"));
		this.list.add(new BandTreeNode(uk.getId(), "Hollow Ground", "1979-1982, 2007, 2013"));
		this.list.add(new BandTreeNode(uk.getId(), "Holocaust", "1977–present"));
		this.list.add(new BandTreeNode(de.getId(), "Holy Moses", "1980–1994, 2000–present"));
		this.list.add(new BandTreeNode(us.getId(), "Icon", "1981–1990, 2008–present"));
		this.list.add(new BandTreeNode(us.getId(), "Iron Butterfly", "1966–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Iron Claw", "1969-1974, 1993, 2010–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Iron Maiden", "1975–present"));
		this.list.add(new BandTreeNode(us.getId(), "Jag Panzer", "1981–1988, 1994–2011"));
		this.list.add(new BandTreeNode(uk.getId(), "Jaguar", "1979–1985, 1998–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Jameson Raid", "1975–1983, 2008–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Jerusalem", "1972–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Jethro Tull", "1967-2014"));
		this.list.add(new BandTreeNode(us.getId(), "Josefus", "1969–2005"));
		this.list.add(new BandTreeNode(us.getId(), "Journey", "1973–present"));
		this.list.add(new BandTreeNode(us.getId(), "JPT Scare Band", "1973–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Judas Priest", "1969–present"));
		this.list.add(new BandTreeNode(pl.getId(), "Kat", "1979-1987, 1990-1999, 2002–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Kick Axe", "1976–1988, 2003–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Killer Dwarfs", "1981–1995, 2001–2008"));
		this.list.add(new BandTreeNode(us.getId(), "Killing Joke", "1978-1996, 2002–present"));
		this.list.add(new BandTreeNode(uk.getId(), "King Crimson", "1968-1974, 1981-1984, 1994-present"));
		this.list.add(new BandTreeNode(us.getId(), "King's X", "1980–present"));
		this.list.add(new BandTreeNode(us.getId(), "Kiss", "1973–present"));
		this.list.add(new BandTreeNode(us.getId(), "Kix", "1977–1996, 2003–present"));
		this.list.add(new BandTreeNode(ch.getId(), "Krokus", "1974–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Leaf Hound", "1969-1971, 2004–present"));
		this.list.add(new BandTreeNode(us.getId(), "Leatherwolf", "1981–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Led Zeppelin", "1968–1980, 2007, 2011"));
		this.list.add(new BandTreeNode(us.getId(), "Legs Diamond", "1975–present"));
		this.list.add(new BandTreeNode(es.getId(), "Leño", "1978-1983"));
		this.list.add(new BandTreeNode(se.getId(), "Leviticus", "1981–1990"));
		this.list.add(new BandTreeNode(uk.getId(), "Lionheart", "1980-1986"));
		this.list.add(new BandTreeNode(de.getId(), "Living Death", "1980-1991"));
		this.list.add(new BandTreeNode(us.getId(), "London", "1978–1981, 1984–1990, 2006–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Lone Star", "1975–1978"));
		this.list.add(new BandTreeNode(es.getId(), "Los Suaves", "1980–present"));
		this.list.add(new BandTreeNode(jp.getId(), "Loudness", "1980–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Loverboy", "1979-1988, 1989, 1991–present"));
		this.list.add(new BandTreeNode(de.getId(), "Lucifer's Friend", "1970–1982, 1993–1997"));
		this.list.add(new BandTreeNode(ca.getId(), "Mahogany Rush", "1970–1980, 1998–present"));
		this.list.add(new BandTreeNode(us.getId(), "Malice", "1980-1989, 2006–present"));
		this.list.add(new BandTreeNode(se.getId(), "Yngwie Malmsteen", "1978–present"));
		this.list.add(new BandTreeNode(ie.getId(), "Mama's Boys", "1978–1993"));
		this.list.add(new BandTreeNode(us.getId(), "Manilla Road", "1977-1990, 2001–present"));
		this.list.add(new BandTreeNode(us.getId(), "Manowar", "1980–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Marseille", "1976–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Max Webster", "1973–1982"));
		this.list.add(new BandTreeNode(uk.getId(), "May Blitz", "1969–1972"));
		this.list.add(new BandTreeNode(us.getId(), "MC5", "1963-1972, 1992, 2003-2012"));
		this.list.add(new BandTreeNode(us.getId(), "Mentors", "1977–present"));
		this.list.add(new BandTreeNode(dk.getId(), "Mercyful Fate", "1981–1985, 1992–1999"));
		this.list.add(new BandTreeNode(us.getId(), "Metal Church", "1980–1994, 1998–2009"));
		this.list.add(new BandTreeNode(us.getId(), "Metallica", "1981–present"));
		this.list.add(new BandTreeNode(us.getId(), "Ministry", "1981-2008, 2011–present"));
		this.list.add(new BandTreeNode(us.getId(), "Misfits", "1977–1983, 1995–present"));
		this.list.add(new BandTreeNode(us.getId(), "Montrose", "1973–1976, 2005"));
		this.list.add(new BandTreeNode(uk.getId(), "More", "1980–1982, 1985, 1998–2000"));
		this.list.add(new BandTreeNode(us.getId(), "Mötley Crüe", "1981–2015"));
		this.list.add(new BandTreeNode(uk.getId(), "Motörhead", "1975–2015"));
		this.list.add(new BandTreeNode(us.getId(), "Mountain", "1969–1972, 1973–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Moxy", "1974-1983, 1999-2009"));
		this.list.add(new BandTreeNode(uk.getId(), "Napalm Death", "1981–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Nazareth", "1968–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Necromandus", "1970–1973"));
		this.list.add(new BandTreeNode(uk.getId(), "The Next Band", "1978-1982"));
		this.list.add(new BandTreeNode(de.getId(), "Night Sun", "1970–1973"));
		this.list.add(new BandTreeNode(uk.getId(), "Nightwing", "1978–1987, 1996–present"));
		this.list.add(new BandTreeNode(us.getId(), "Ted Nugent", "1975–present"));
		this.list.add(new BandTreeNode(us.getId(), "The Obsessed", "1976–1986, 1990–1995, 2011–present"));
		this.list.add(new BandTreeNode(us.getId(), "Overkill", "1980–present"));
		this.list.add(new BandTreeNode(fi.getId(), "Oz", "1977-1991, 2010–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Ozzy Osbourne", "1980–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Pagan Altar", "1978–1982, 2004–present"));
		this.list.add(new BandTreeNode(us.getId(), "Pantera", "1981-2003"));
		this.list.add(new BandTreeNode(us.getId(), "Pentagram", "1971–1976, 1978–1979, 1981–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Persian Risk", "1979–1986"));
		this.list.add(new BandTreeNode(nl.getId(), "Picture", "1979–1987, 1997–1999, 2007–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Pink Fairies", "1970-1976, 1987-1988"));
		this.list.add(new BandTreeNode(uk.getId(), "Praying Mantis", "1974–present"));
		this.list.add(new BandTreeNode(dk.getId(), "Pretty Maids", "1981–present"));
		this.list.add(new BandTreeNode(us.getId(), "Primevil", "1973-1974"));
		this.list.add(new BandTreeNode(uk.getId(), "Quartz", "1974-1983, 1996, 2011"));
		this.list.add(new BandTreeNode(uk.getId(), "Queen", "1970-1991"));
		this.list.add(new BandTreeNode(us.getId(), "Queensrÿche", "1981–present"));
		this.list.add(new BandTreeNode(us.getId(), "Quiet Riot", "1975–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Rainbow", "1975–1984, 1993–1997"));
		this.list.add(new BandTreeNode(us.getId(), "Ratt", "1976–1992, 1996–Present"));
		this.list.add(new BandTreeNode(uk.getId(), "Raven", "1974–present"));
		this.list.add(new BandTreeNode(us.getId(), "Riot", "1975–1984, 1986–2012"));
		this.list.add(new BandTreeNode(uk.getId(), "Rock Goddess", "1977–1987, 1994–1995, 2009, 2015"));
		this.list.add(new BandTreeNode(us.getId(), "The Rods", "1978-1986, 2008–present"));
		this.list.add(new BandTreeNode(au.getId(), "Rose Tattoo", "1976–1987, 1993, 1998–present"));
		this.list.add(new BandTreeNode(de.getId(), "Uli Jon Roth", "1968–present"));
		this.list.add(new BandTreeNode(us.getId(), "Rough Cutt", "1981–1987, 2000–2002"));
		this.list.add(new BandTreeNode(us.getId(), "The Runaways", "1975–1979"));
		this.list.add(new BandTreeNode(de.getId(), "Running Wild", "1976–2009, 2011–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Rush", "1968–present"));
		this.list.add(new BandTreeNode(jp.getId(), "Saber Tiger", "1981–present"));
		this.list.add(new BandTreeNode(us.getId(), "Sacred Rite", "1980-1990"));
		this.list.add(new BandTreeNode(us.getId(), "Saint", "1980–1989, 1999–present"));
		this.list.add(new BandTreeNode(us.getId(), "Saint Vitus", "1978–1996, 2003, 2008–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Salem", "1980–1983, 2009–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Paul Samson", "1978–2002"));
		this.list.add(new BandTreeNode(uk.getId(), "Satan", "1979–88, 2005–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Savage", "1976–present"));
		this.list.add(new BandTreeNode(us.getId(), "Savage Grace", "1981–1993, 2009-2010"));
		this.list.add(new BandTreeNode(us.getId(), "Savatage", "1978–2002"));
		this.list.add(new BandTreeNode(uk.getId(), "Saxon", "1976–present"));
		this.list.add(new BandTreeNode(de.getId(), "Michael Schenker Group", "1979–present"));
		this.list.add(new BandTreeNode(de.getId(), "Scorpions", "1965–present"));
		this.list.add(new BandTreeNode(us.getId(), "Shark Island", "1979-1992"));
		this.list.add(new BandTreeNode(us.getId(), "Sir Lord Baltimore", "1968-1976, 2006–present"));
		this.list.add(new BandTreeNode(us.getId(), "Sister", "1976–1978"));
		this.list.add(new BandTreeNode(us.getId(), "Skitzo", "1981–present"));
		this.list.add(new BandTreeNode(us.getId(), "Slayer", "1981–present"));
		this.list.add(new BandTreeNode(de.getId(), "Sodom", "1981–present"));
		this.list.add(new BandTreeNode(us.getId(), "Sorcery", "1976-1987"));
		this.list.add(new BandTreeNode(fr.getId(), "Sortilège", "1981–1986"));
		this.list.add(new BandTreeNode(us.getId(), "Sound Barrier", "1980-1987"));
		this.list.add(new BandTreeNode(us.getId(), "Spinal Tap", "1979–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Spider", "1976-1986"));
		this.list.add(new BandTreeNode(uk.getId(), "Stampede", "1981-1983, 2009–present"));
		this.list.add(new BandTreeNode(us.getId(), "Starz", "1975–1979, 1980, 1990, 2003–present"));
		this.list.add(new BandTreeNode(de.getId(), "Steeler", "1981–1988"));
		this.list.add(new BandTreeNode(de.getId(), "Stormwitch", "1979–1994, 2002–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Stray", "1966–present"));
		this.list.add(new BandTreeNode(za.getId(), "Suck", "1970–1971"));
		this.list.add(new BandTreeNode(us.getId(), "Suicidal Tendencies", "1981–1995, 1997–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Sweet Savage", "1979–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Tank", "1980-1989, 1997–present"));
		this.list.add(new BandTreeNode(us.getId(), "Tesla", "1981–1996, 2000–present"));
		this.list.add(new BandTreeNode(ie.getId(), "Thin Lizzy", "1969–1984, 1996–2012"));
		this.list.add(new BandTreeNode(ca.getId(), "Thor", "1978, 1983–1986, 1997–present"));
		this.list.add(new BandTreeNode(us.getId(), "TKO", "1977–2001"));
		this.list.add(new BandTreeNode(ch.getId(), "Toad", "1970–1995"));
		this.list.add(new BandTreeNode(uk.getId(), "Tobruk", "1981–1987"));
		this.list.add(new BandTreeNode(uk.getId(), "Trespass", "1978–1982, 1992–1993"));
		this.list.add(new BandTreeNode(ca.getId(), "Triumph", "1975–1993, 2008–present"));
		this.list.add(new BandTreeNode(us.getId(), "Trouble", "1979–present"));
		this.list.add(new BandTreeNode(ca.getId(), "Trooper", "1974–present"));
		this.list.add(new BandTreeNode(fr.getId(), "Trust", "1977-1985, 1988, 1996-2000, 2006"));
		this.list.add(new BandTreeNode(pl.getId(), "TSA", "1979–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Tucky Buzzard", "1969-1974"));
		this.list.add(new BandTreeNode(pl.getId(), "Turbo", "1980–present"));
		this.list.add(new BandTreeNode(us.getId(), "Twisted Sister", "1972–1988, 1997–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Tygers of Pan Tang", "1978–1987, 1999–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Tytan", "1981-1983, 2012–present"));
		this.list.add(new BandTreeNode(uk.getId(), "UFO", "1969–1988, 1992–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Urchin", "1972-1980"));
		this.list.add(new BandTreeNode(uk.getId(), "Uriah Heep", "1969–present"));
		this.list.add(new BandTreeNode(ar.getId(), "V8", "1979–1987"));
		this.list.add(new BandTreeNode(nl.getId(), "Vandenberg", "1981–1987"));
		this.list.add(new BandTreeNode(us.getId(), "Van Halen", "1972–present"));
		this.list.add(new BandTreeNode(us.getId(), "Vanilla Fudge", "1967–1970, 1982–1984, 1987–1988, 1991, 1999–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Vardis", "1973–1986, 2013–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Venom", "1979–present"));
		this.list.add(new BandTreeNode(us.getId(), "Vicious Rumors", "1979–present"));
		this.list.add(new BandTreeNode(us.getId(), "Virgin Steele", "1981–present"));
		this.list.add(new BandTreeNode(us.getId(), "Vixen", "1980–1991, 1997–1998, 2001–present"));
		this.list.add(new BandTreeNode(fr.getId(), "Vulcain", "1981-1998, 2009–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Warhorse", "1970–1974, (partial reunions: 1985, 2005)"));
		this.list.add(new BandTreeNode(fr.getId(), "Warning", "1980-1985"));
		this.list.add(new BandTreeNode(us.getId(), "White Sister", "1980-1986, 2008-2009"));
		this.list.add(new BandTreeNode(uk.getId(), "Whitesnake", "1978–1990, 1994, 1997, 2002–present"));
		this.list.add(new BandTreeNode(uk.getId(), "White Spirit", "1975-1981"));
		this.list.add(new BandTreeNode(ca.getId(), "White Wolf", "1975-1986, 2007–present"));
		this.list.add(new BandTreeNode(us.getId(), "Wild Dogs", "1981–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Wild Horses", "1978–1981"));
		this.list.add(new BandTreeNode(uk.getId(), "Wishbone Ash", "1969–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Witchfinder General", "1979–1984, 2006–2008"));
		this.list.add(new BandTreeNode(uk.getId(), "Witchfynde", "1974–1984, 1999–present"));
		this.list.add(new BandTreeNode(uk.getId(), "The Who", "1964-1982, 1989, 1996–present"));
		this.list.add(new BandTreeNode(uk.getId(), "Wrathchild", "1980–1990, 2009–present"));
		this.list.add(new BandTreeNode(us.getId(), "Wrathchild America", "1978-1993"));
		this.list.add(new BandTreeNode(us.getId(), "Y&T", "1974–1991, 1995–present"));
	}

	private static synchronized BandsDAO get()
	{
		if (instance == null)
		{
			instance = new BandsDAO();
		}

		return instance;
	}

	public static List<CountryTreeNode> countries()
	{
		List<CountryTreeNode> countries = Generics.newArrayList();

		for (TreeNode<?> node : get().list)
		{
			if (node instanceof CountryTreeNode)
			{
				countries.add((CountryTreeNode) node);
			}
		}

		return countries;
	}

	public static List<BandTreeNode> bands(long countryId)
	{
		List<BandTreeNode> bands = Generics.newArrayList();

		for (TreeNode<?> node : get().list)
		{
			if ((node instanceof BandTreeNode) && ((BandTreeNode) node).getParentId() == countryId)
			{
				bands.add((BandTreeNode) node);
			}
		}

		return bands;
	}
}
