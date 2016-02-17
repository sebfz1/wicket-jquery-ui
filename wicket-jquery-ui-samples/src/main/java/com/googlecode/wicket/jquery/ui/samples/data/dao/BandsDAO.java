package com.googlecode.wicket.jquery.ui.samples.data.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.googlecode.wicket.jquery.ui.samples.data.bean.Band;
import com.googlecode.wicket.jquery.ui.samples.data.bean.Country;

import java.util.Set;

public class BandsDAO
{
	private static BandsDAO instance = null;

	private final Map<Country, List<Band>> map;

	public BandsDAO()
	{
		this.map = new HashMap<Country, List<Band>>();

		Country ar = new Country("ar", "Argentina");
		List<Band> arBands = new ArrayList<Band>();
		this.map.put(ar, arBands);
		Country au = new Country("au", "Australia");
		List<Band> auBands = new ArrayList<Band>();
		this.map.put(au, auBands);
		Country ca = new Country("ca", "Canada");
		List<Band> caBands = new ArrayList<Band>();
		this.map.put(ca, caBands);
		Country dk = new Country("dk", "Denmark");
		List<Band> dkBands = new ArrayList<Band>();
		this.map.put(dk, dkBands);
		Country fi = new Country("fi", "Finland");
		List<Band> fiBands = new ArrayList<Band>();
		this.map.put(fi, fiBands);
		Country fr = new Country("fr", "France");
		List<Band> frBands = new ArrayList<Band>();
		this.map.put(fr, frBands);
		Country de = new Country("de", "Germany");
		List<Band> deBands = new ArrayList<Band>();
		this.map.put(de, deBands);
		Country ie = new Country("ie", "Ireland");
		List<Band> ieBands = new ArrayList<Band>();
		this.map.put(ie, ieBands);
		Country it = new Country("it", "Italy");
		List<Band> itBands = new ArrayList<Band>();
		this.map.put(it, itBands);
		Country jp = new Country("jp", "Japan");
		List<Band> jpBands = new ArrayList<Band>();
		this.map.put(jp, jpBands);
		Country nl = new Country("nl", "Netherlands");
		List<Band> nlBands = new ArrayList<Band>();
		this.map.put(nl, nlBands);
		Country pl = new Country("pl", "Poland");
		List<Band> plBands = new ArrayList<Band>();
		this.map.put(pl, plBands);
		Country za = new Country("za", "South Africa");
		List<Band> zaBands = new ArrayList<Band>();
		this.map.put(za, zaBands);
		Country es = new Country("es", "Spain");
		List<Band> esBands = new ArrayList<Band>();
		this.map.put(es, esBands);
		Country se = new Country("se", "Sweden");
		List<Band> seBands = new ArrayList<Band>();
		this.map.put(se, seBands);
		Country ch = new Country("ch", "Switzerland");
		List<Band> chBands = new ArrayList<Band>();
		this.map.put(ch, chBands);
		Country uk = new Country("uk", "United Kingdom");
		List<Band> ukBands = new ArrayList<Band>();
		this.map.put(uk, ukBands);
		Country us = new Country("us", "United States");
		List<Band> usBands = new ArrayList<Band>();
		this.map.put(us, usBands);
		
		jpBands.add(new Band("band1", "44 Magnum", "1977–1989, 2002–present"));
		seBands.add(new Band("band2", "220 Volt", "1979–present"));
		ukBands.add(new Band("band3", "A II Z", "1979-1982"));
		auBands.add(new Band("band4", "AC/DC", "1973–present"));
		deBands.add(new Band("band5", "Accept", "1976–1989, 1992–1997, 2004–2005, 2009–present"));
		usBands.add(new Band("band6", "Aerosmith", "1970–present"));
		usBands.add(new Band("band7", "Alice Cooper", "1968–present"));
		usBands.add(new Band("band8", "Angel", "1975–1981, 1987, 1998–present"));
		esBands.add(new Band("band9", "Ángeles del Infierno", "1978–present"));
		auBands.add(new Band("band10", "The Angels", "1974-2000, 2008–present"));
		ukBands.add(new Band("band11", "Angel Witch", "1977-1982, 1984-1998, 2000–present"));
		jpBands.add(new Band("band12", "Anthem", "1980–1992, 2000–present"));
		usBands.add(new Band("band13", "Anthrax", "1981–present"));
		usBands.add(new Band("band14", "Avenged Sevenfold", "1999–present"));
		caBands.add(new Band("band15", "Anvil", "1978–present"));
		caBands.add(new Band("band16", "April Wine", "1969-1986, 1992–present"));
		ukBands.add(new Band("band17", "Armageddon", "1974–1976"));
		ukBands.add(new Band("band18", "Atomic Rooster", "1969–1975, 1980–1983"));
		ukBands.add(new Band("band19", "Atomkraft", "1979–1988, 2005"));
		usBands.add(new Band("band20", "Attila", "1969-1970"));
		usBands.add(new Band("band21", "Axe", "1979-1984, 1997-2004"));
		ukBands.add(new Band("band22", "Babe Ruth", "1970-1976, 2005–present"));
		usBands.add(new Band("band23", "Bang", "1970–1973, 2001–2004"));
		usBands.add(new Band("band24", "Barnabas", "1977-1986"));
		esBands.add(new Band("band25", "Barón Rojo", "1980–present"));
		ukBands.add(new Band("band26", "Battleaxe", "1980–1988, 2010–present"));
		ukBands.add(new Band("band27", "The Beatles", "1960-1970"));
		auBands.add(new Band("band28", "Bengal Tigers", "1979–present"));
		usBands.add(new Band("band29", "Beowülf", "1981–1995, 2000–present"));
		deBands.add(new Band("band30", "Birth Control", "1966-1983, 1993-2014"));
		usBands.add(new Band("band31", "Bitch", "1980–present"));
		usBands.add(new Band("band32", "Black Death", "1977–present"));
		usBands.add(new Band("band33", "Black 'n Blue", "1981–1989, 1997, 2003, 2007–present"));
		ukBands.add(new Band("band34", "Black Rose", "1980-1989, 2006–present"));
		ukBands.add(new Band("band35", "Black Sabbath", "1968–2006, 2011–present"));
		ukBands.add(new Band("band36", "Black Widow", "1966–1973, 2007–present"));
		ukBands.add(new Band("band37", "Blitzkrieg", "1980–1981, 1984–1991, 1992–1994, 1996–1999, 2001–present"));
		usBands.add(new Band("band38", "Bloodrock", "1969–1975"));
		usBands.add(new Band("band39", "Blue Cheer", "1966–1972, 1974–1976, 1978–1979, 1984–1994, 1999–2009"));
		usBands.add(new Band("band40", "Blue Öyster Cult", "1967–present"));
		nlBands.add(new Band("band41", "Bodine", "1978-1984"));
		auBands.add(new Band("band42", "Boss", "1979-1986"));
		jpBands.add(new Band("band43", "Bow Wow", "1976–present"));
		ukBands.add(new Band("band44", "Bronz", "1976-1985, 1999-2000, 2003–2005, 2010–present"));
		ukBands.add(new Band("band45", "Edgar Broughton Band", "1968–2010"));
		ukBands.add(new Band("band46", "Budgie", "1967–present"));
		auBands.add(new Band("band47", "Buffalo", "1971–1977"));
		itBands.add(new Band("band48", "Bulldozer", "1980–1990, 2008–present"));
		usBands.add(new Band("band49", "Cactus", "1970–1972, 2006–present"));
		usBands.add(new Band("band50", "Captain Beyond", "1971-1973, 1976-1978, 1998-2003"));
		ukBands.add(new Band("band51", "Chateaux", "1981-1985"));
		usBands.add(new Band("band52", "Cirith Ungol", "1972–1992"));
		ukBands.add(new Band("band53", "Cloven Hoof", "1979–1990, 2000–present"));
		usBands.add(new Band("band54", "Coven", "1969–1975, 2007–2008"));
		ukBands.add(new Band("band55", "Cream", "1966–1969"));
		usBands.add(new Band("band56", "Crimson Glory", "1979–1992, 1998–present"));
		ukBands.add(new Band("band57", "Crushed Butler", "1969-1971"));
		usBands.add(new Band("band58", "Dark Angel", "1981–1992, 2002–2005, 2013–present"));
		itBands.add(new Band("band59", "Death SS", "1977-1984, 1988–present"));
		ukBands.add(new Band("band60", "Dedringer", "1977-1985"));
		ukBands.add(new Band("band61", "Deep Machine", "1979-1982, 2009–present"));
		ukBands.add(new Band("band62", "Deep Purple", "1968-1976, 1984–present"));
		ukBands.add(new Band("band63", "Def Leppard", "1977–present"));
		ukBands.add(new Band("band64", "Demon", "1979–present"));
		ukBands.add(new Band("band65", "The Deviants", "1967–1969, 1978, 1984, 1996, 2002, 2011–present"));
		ukBands.add(new Band("band66", "Diamond Head", "1976–1985, 1991–1994, 2002–present"));
		usBands.add(new Band("band68", "Dokken", "1978–1989, 1993–present"));
		usBands.add(new Band("band69", "Dust", "1969-1972"));
		jpBands.add(new Band("band70", "Earthshaker", "1978-1994, 1999–present"));
		seBands.add(new Band("band71", "Easy Action", "1981–1986, 2006–present"));
		seBands.add(new Band("band72", "E.F. Band", "1979-1986"));
		deBands.add(new Band("band73", "Electric Sun", "1978-1986"));
		usBands.add(new Band("band74", "Elf", "1967-1975"));
		deBands.add(new Band("band75", "Eloy", "1969-1984, 1988-present"));
		ukBands.add(new Band("band76", "Emerson, Lake & Palmer", "1970-1979, 1991-1998"));
		ukBands.add(new Band("band77", "Ethel the Frog", "1976-1980"));
		seBands.add(new Band("band78", "Europe", "1979–1992, 1999 (partial reunion), 2003–present"));
		caBands.add(new Band("band79", "Exciter", "1978–present"));
		usBands.add(new Band("band80", "Exodus", "1980–1993, 1997–1998, 2001–present"));
		usBands.add(new Band("band81", "Faith No More", "1979–1998, 2009–present"));
		usBands.add(new Band("band82", "Fallout", "1979-1982"));
		ukBands.add(new Band("band83", "Fist", "1978-1982, 2001–2006"));
		usBands.add(new Band("band84", "Flotsam and Jetsam", "1981–present"));
		jpBands.add(new Band("band85", "Flower Travellin' Band", "1968–1973, 2007–present"));
		ukBands.add(new Band("band86", "The Flying Hat Band", "1971–1974"));
		usBands.add(new Band("band87", "Gamma", "1978–1983, 2000"));
		ukBands.add(new Band("band88", "Genesis", "1967-1998, 2006–present"));
		ukBands.add(new Band("band89", "Geordie", "1972–1980, 1982–1985, 2001"));
		usBands.add(new Band("band90", "GG Allin", "1972-1993"));
		ukBands.add(new Band("band91", "Gillan", "1978–1983"));
		ukBands.add(new Band("band92", "Girl", "1979-1982"));
		ukBands.add(new Band("band93", "Girlschool", "1978–present"));
		usBands.add(new Band("band95", "Grand Funk Railroad", "1968–1977, 1980–1983, 1996–present"));
		deBands.add(new Band("band96", "Grave Digger", "1980–1987, 1991–present"));
		deBands.add(new Band("band97", "Gravestone", "1977-1986"));
		usBands.add(new Band("band98", "Great White", "1977–2001, 2002–present"));
		ukBands.add(new Band("band99", "Grim Reaper", "1979–1988, 2006–present"));
		ukBands.add(new Band("band100", "The Gun", "1967-1970"));
		usBands.add(new Band("band101", "Sammy Hagar", "1967–present"));
		ukBands.add(new Band("band102", "The Handsome Beasts", "1972–present"));
		fiBands.add(new Band("band103", "Hanoi Rocks", "1979–1985, 2001–2009"));
		ukBands.add(new Band("band104", "Hard Stuff", "1971–1973"));
		ukBands.add(new Band("band105", "Hawkwind", "1969–present"));
		caBands.add(new Band("band106", "Headpins", "1979–present"));
		usBands.add(new Band("band107", "Heart", "1973–present"));
		auBands.add(new Band("band108", "Heaven", "1980–2000"));
		seBands.add(new Band("band109", "Heavy Load", "1976–1985"));
		ukBands.add(new Band("band110", "Heavy Metal Kids", "1972-1985, 2002–present"));
		caBands.add(new Band("band111", "Helix", "1974–present"));
		ukBands.add(new Band("band112", "The Jimi Hendrix Experience", "1966–1970"));
		ukBands.add(new Band("band113", "High Tide", "1969–1970"));
		fiBands.add(new Band("band114", "HIM", "1991 - present"));
		ukBands.add(new Band("band115", "Hollow Ground", "1979-1982, 2007, 2013"));
		ukBands.add(new Band("band116", "Holocaust", "1977–present"));
		deBands.add(new Band("band117", "Holy Moses", "1980–1994, 2000–present"));
		usBands.add(new Band("band118", "Icon", "1981–1990, 2008–present"));
		usBands.add(new Band("band119", "Iron Butterfly", "1966–present"));
		ukBands.add(new Band("band120", "Iron Claw", "1969-1974, 1993, 2010–present"));
		ukBands.add(new Band("band121", "Iron Maiden", "1975–present"));
		usBands.add(new Band("band122", "Jag Panzer", "1981–1988, 1994–2011"));
		ukBands.add(new Band("band123", "Jaguar", "1979–1985, 1998–present"));
		ukBands.add(new Band("band124", "Jameson Raid", "1975–1983, 2008–present"));
		ukBands.add(new Band("band125", "Jerusalem", "1972–present"));
		ukBands.add(new Band("band126", "Jethro Tull", "1967-2014"));
		usBands.add(new Band("band127", "Josefus", "1969–2005"));
		usBands.add(new Band("band128", "Journey", "1973–present"));
		usBands.add(new Band("band129", "JPT Scare Band", "1973–present"));
		ukBands.add(new Band("band130", "Judas Priest", "1969–present"));
		plBands.add(new Band("band131", "Kat", "1979-1987, 1990-1999, 2002–present"));
		caBands.add(new Band("band133", "Kick Axe", "1976–1988, 2003–present"));
		caBands.add(new Band("band134", "Killer Dwarfs", "1981–1995, 2001–2008"));
		usBands.add(new Band("band135", "Killing Joke", "1978-1996, 2002–present"));
		ukBands.add(new Band("band136", "King Crimson", "1968-1974, 1981-1984, 1994-present"));
		usBands.add(new Band("band137", "King's X", "1980–present"));
		usBands.add(new Band("band138", "Kiss", "1973–present"));
		usBands.add(new Band("band139", "Kix", "1977–1996, 2003–present"));
		chBands.add(new Band("band140", "Krokus", "1974–present"));
		ukBands.add(new Band("band141", "Leaf Hound", "1969-1971, 2004–present"));
		usBands.add(new Band("band142", "Leatherwolf", "1981–present"));
		ukBands.add(new Band("band143", "Led Zeppelin", "1968–1980, 2007, 2011"));
		usBands.add(new Band("band144", "Legs Diamond", "1975–present"));
		esBands.add(new Band("band145", "Leño", "1978-1983"));
		seBands.add(new Band("band146", "Leviticus", "1981–1990"));
		ukBands.add(new Band("band147", "Lionheart", "1980-1986"));
		deBands.add(new Band("band148", "Living Death", "1980-1991"));
		usBands.add(new Band("band149", "London", "1978–1981, 1984–1990, 2006–present"));
		ukBands.add(new Band("band150", "Lone Star", "1975–1978"));
		esBands.add(new Band("band151", "Los Suaves", "1980–present"));
		jpBands.add(new Band("band152", "Loudness", "1980–present"));
		caBands.add(new Band("band153", "Loverboy", "1979-1988, 1989, 1991–present"));
		deBands.add(new Band("band154", "Lucifer's Friend", "1970–1982, 1993–1997"));
		caBands.add(new Band("band155", "Mahogany Rush", "1970–1980, 1998–present"));
		usBands.add(new Band("band156", "Malice", "1980-1989, 2006–present"));
		seBands.add(new Band("band157", "Yngwie Malmsteen", "1978–present"));
		ieBands.add(new Band("band158", "Mama's Boys", "1978–1993"));
		usBands.add(new Band("band159", "Manilla Road", "1977-1990, 2001–present"));
		usBands.add(new Band("band160", "Manowar", "1980–present"));
		ukBands.add(new Band("band161", "Marseille", "1976–present"));
		caBands.add(new Band("band162", "Max Webster", "1973–1982"));
		ukBands.add(new Band("band163", "May Blitz", "1969–1972"));
		usBands.add(new Band("band164", "MC5", "1963-1972, 1992, 2003-2012"));
		usBands.add(new Band("band165", "Mentors", "1977–present"));
		dkBands.add(new Band("band166", "Mercyful Fate", "1981–1985, 1992–1999"));
		usBands.add(new Band("band167", "Metal Church", "1980–1994, 1998–2009"));
		usBands.add(new Band("band168", "Metallica", "1981–present"));
		usBands.add(new Band("band169", "Ministry", "1981-2008, 2011–present"));
		usBands.add(new Band("band170", "Misfits", "1977–1983, 1995–present"));
		usBands.add(new Band("band171", "Montrose", "1973–1976, 2005"));
		ukBands.add(new Band("band172", "More", "1980–1982, 1985, 1998–2000"));
		usBands.add(new Band("band173", "Mötley Crüe", "1981–2015"));
		ukBands.add(new Band("band174", "Motörhead", "1975–2015"));
		usBands.add(new Band("band175", "Mountain", "1969–1972, 1973–present"));
		caBands.add(new Band("band176", "Moxy", "1974-1983, 1999-2009"));
		ukBands.add(new Band("band177", "Napalm Death", "1981–present"));
		ukBands.add(new Band("band178", "Nazareth", "1968–present"));
		ukBands.add(new Band("band179", "Necromandus", "1970–1973"));
		ukBands.add(new Band("band180", "The Next Band", "1978-1982"));
		deBands.add(new Band("band181", "Night Sun", "1970–1973"));
		ukBands.add(new Band("band182", "Nightwing", "1978–1987, 1996–present"));
		usBands.add(new Band("band183", "Ted Nugent", "1975–present"));
		usBands.add(new Band("band184", "The Obsessed", "1976–1986, 1990–1995, 2011–present"));
		usBands.add(new Band("band185", "Overkill", "1980–present"));
		fiBands.add(new Band("band186", "Oz", "1977-1991, 2010–present"));
		ukBands.add(new Band("band187", "Ozzy Osbourne", "1980–present"));
		ukBands.add(new Band("band188", "Pagan Altar", "1978–1982, 2004–present"));
		usBands.add(new Band("band189", "Pantera", "1981-2003"));
		usBands.add(new Band("band190", "Pentagram", "1971–1976, 1978–1979, 1981–present"));
		ukBands.add(new Band("band191", "Persian Risk", "1979–1986"));
		nlBands.add(new Band("band192", "Picture", "1979–1987, 1997–1999, 2007–present"));
		ukBands.add(new Band("band193", "Pink Fairies", "1970-1976, 1987-1988"));
		ukBands.add(new Band("band194", "Praying Mantis", "1974–present"));
		dkBands.add(new Band("band195", "Pretty Maids", "1981–present"));
		usBands.add(new Band("band196", "Primevil", "1973-1974"));
		ukBands.add(new Band("band197", "Quartz", "1974-1983, 1996, 2011"));
		ukBands.add(new Band("band198", "Queen", "1970-1991"));
		usBands.add(new Band("band199", "Queensrÿche", "1981–present"));
		usBands.add(new Band("band200", "Quiet Riot", "1975–present"));
		ukBands.add(new Band("band201", "Rainbow", "1975–1984, 1993–1997"));
		usBands.add(new Band("band202", "Ratt", "1976–1992, 1996–Present"));
		ukBands.add(new Band("band203", "Raven", "1974–present"));
		usBands.add(new Band("band204", "Riot", "1975–1984, 1986–2012"));
		ukBands.add(new Band("band205", "Rock Goddess", "1977–1987, 1994–1995, 2009, 2015"));
		usBands.add(new Band("band206", "The Rods", "1978-1986, 2008–present"));
		auBands.add(new Band("band208", "Rose Tattoo", "1976–1987, 1993, 1998–present"));
		deBands.add(new Band("band209", "Uli Jon Roth", "1968–present"));
		usBands.add(new Band("band210", "Rough Cutt", "1981–1987, 2000–2002"));
		usBands.add(new Band("band211", "The Runaways", "1975–1979"));
		deBands.add(new Band("band212", "Running Wild", "1976–2009, 2011–present"));
		caBands.add(new Band("band213", "Rush", "1968–present"));
		jpBands.add(new Band("band214", "Saber Tiger", "1981–present"));
		usBands.add(new Band("band215", "Sacred Rite", "1980-1990"));
		usBands.add(new Band("band216", "Saint", "1980–1989, 1999–present"));
		usBands.add(new Band("band217", "Saint Vitus", "1978–1996, 2003, 2008–present"));
		ukBands.add(new Band("band218", "Salem", "1980–1983, 2009–present"));
		ukBands.add(new Band("band219", "Paul Samson", "1978–2002"));
		ukBands.add(new Band("band220", "Satan", "1979–88, 2005–present"));
		ukBands.add(new Band("band221", "Savage", "1976–present"));
		usBands.add(new Band("band222", "Savage Grace", "1981–1993, 2009-2010"));
		usBands.add(new Band("band223", "Savatage", "1978–2002"));
		ukBands.add(new Band("band224", "Saxon", "1976–present"));
		deBands.add(new Band("band225", "Michael Schenker Group", "1979–present"));
		deBands.add(new Band("band226", "Scorpions", "1965–present"));
		usBands.add(new Band("band227", "Shark Island", "1979-1992"));
		usBands.add(new Band("band228", "Sir Lord Baltimore", "1968-1976, 2006–present"));
		usBands.add(new Band("band229", "Sister", "1976–1978"));
		usBands.add(new Band("band230", "Skitzo", "1981–present"));
		usBands.add(new Band("band231", "Slayer", "1981–present"));
		deBands.add(new Band("band232", "Sodom", "1981–present"));
		usBands.add(new Band("band233", "Sorcery", "1976-1987"));
		frBands.add(new Band("band234", "Sortilège", "1981–1986"));
		usBands.add(new Band("band235", "Sound Barrier", "1980-1987"));
		usBands.add(new Band("band236", "Spinal Tap", "1979–present"));
		ukBands.add(new Band("band237", "Spider", "1976-1986"));
		ukBands.add(new Band("band238", "Stampede", "1981-1983, 2009–present"));
		usBands.add(new Band("band239", "Starz", "1975–1979, 1980, 1990, 2003–present"));
		deBands.add(new Band("band240", "Steeler", "1981–1988"));
		deBands.add(new Band("band242", "Stormwitch", "1979–1994, 2002–present"));
		ukBands.add(new Band("band243", "Stray", "1966–present"));
		zaBands.add(new Band("band244", "Suck", "1970–1971"));
		usBands.add(new Band("band245", "Suicidal Tendencies", "1981–1995, 1997–present"));
		ukBands.add(new Band("band246", "Sweet Savage", "1979–present"));
		ukBands.add(new Band("band247", "Tank", "1980-1989, 1997–present"));
		usBands.add(new Band("band248", "Tesla", "1981–1996, 2000–present"));
		ieBands.add(new Band("band249", "Thin Lizzy", "1969–1984, 1996–2012"));
		caBands.add(new Band("band250", "Thor", "1978, 1983–1986, 1997–present"));
		usBands.add(new Band("band251", "TKO", "1977–2001"));
		chBands.add(new Band("band252", "Toad", "1970–1995"));
		ukBands.add(new Band("band253", "Tobruk", "1981–1987"));
		ukBands.add(new Band("band254", "Trespass", "1978–1982, 1992–1993"));
		caBands.add(new Band("band255", "Triumph", "1975–1993, 2008–present"));
		usBands.add(new Band("band256", "Trouble", "1979–present"));
		caBands.add(new Band("band257", "Trooper", "1974–present"));
		frBands.add(new Band("band258", "Trust", "1977-1985, 1988, 1996-2000, 2006"));
		plBands.add(new Band("band259", "TSA", "1979–present"));
		ukBands.add(new Band("band260", "Tucky Buzzard", "1969-1974"));
		plBands.add(new Band("band261", "Turbo", "1980–present"));
		usBands.add(new Band("band262", "Twisted Sister", "1972–1988, 1997–present"));
		ukBands.add(new Band("band263", "Tygers of Pan Tang", "1978–1987, 1999–present"));
		ukBands.add(new Band("band264", "Tytan", "1981-1983, 2012–present"));
		ukBands.add(new Band("band265", "UFO", "1969–1988, 1992–present"));
		ukBands.add(new Band("band266", "Urchin", "1972-1980"));
		ukBands.add(new Band("band267", "Uriah Heep", "1969–present"));
		arBands.add(new Band("band269", "V8", "1979–1987"));
		nlBands.add(new Band("band270", "Vandenberg", "1981–1987"));
		usBands.add(new Band("band271", "Van Halen", "1972–present"));
		usBands.add(new Band("band272", "Vanilla Fudge", "1967–1970, 1982–1984, 1987–1988, 1991, 1999–present"));
		ukBands.add(new Band("band273", "Vardis", "1973–1986, 2013–present"));
		ukBands.add(new Band("band274", "Venom", "1979–present"));
		usBands.add(new Band("band275", "Vicious Rumors", "1979–present"));
		usBands.add(new Band("band276", "Virgin Steele", "1981–present"));
		usBands.add(new Band("band277", "Vixen", "1980–1991, 1997–1998, 2001–present"));
		frBands.add(new Band("band278", "Vulcain", "1981-1998, 2009–present"));
		ukBands.add(new Band("band279", "Warhorse", "1970–1974, (partial reunions: 1985, 2005)"));
		frBands.add(new Band("band280", "Warning", "1980-1985"));
		usBands.add(new Band("band281", "White Sister", "1980-1986, 2008-2009"));
		ukBands.add(new Band("band282", "Whitesnake", "1978–1990, 1994, 1997, 2002–present"));
		ukBands.add(new Band("band283", "White Spirit", "1975-1981"));
		caBands.add(new Band("band284", "White Wolf", "1975-1986, 2007–present"));
		usBands.add(new Band("band285", "Wild Dogs", "1981–present"));
		ukBands.add(new Band("band286", "Wild Horses", "1978–1981"));
		ukBands.add(new Band("band287", "Wishbone Ash", "1969–present"));
		ukBands.add(new Band("band288", "Witchfinder General", "1979–1984, 2006–2008"));
		ukBands.add(new Band("band289", "Witchfynde", "1974–1984, 1999–present"));
		ukBands.add(new Band("band290", "The Who", "1964-1982, 1989, 1996–present"));
		ukBands.add(new Band("band291", "Wrathchild", "1980–1990, 2009–present"));
		usBands.add(new Band("band292", "Wrathchild America", "1978-1993"));
		usBands.add(new Band("band293", "Y&T", "1974–1991, 1995–present"));
	}

	private static synchronized BandsDAO get()
	{
		if (instance == null)
		{
			instance = new BandsDAO();
		}

		return instance;
	}

	public static Set<Country> countries()
	{
		return BandsDAO.get().map.keySet();
	}

	public static List<Band> bands(String countryId)
	{
		if (countryId != null)
		{
			for (Entry<Country, List<Band>> entry : BandsDAO.get().map.entrySet())
			{
				if (countryId.equals(entry.getKey().getName()))
				{
					return entry.getValue();
				}
			}
		}

		return Collections.emptyList();
	}
}
