<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<form method='post' action='AddNewServlet'>
	<fieldset style="width: 400px">  
            <legend> Welcome to Digibooks.com </legend>
            <table>
			<tr>
				<td>Book Name :</td>
				<td> <input  type="text" name='bookname' placeholder="abcde" required="required"/></td>
			</tr>
			
			<tr>
				<td>Author :</td>
				<td> <input type="text" name='author' placeholder="xyz" required="required"/></td>
			</tr>
			<tr>
				<td>Publication House : </td>
				<td><select name="publicationHouse"  onmouseover="this.size = 10" onmouseout="this.size = 1">
		  <option value="0">Select Role</option>
		  <option value="1">Oxford University Press</option>
		  <option value="2">HarperFlamingo Canada</option>
		  <option value="3">HarperPerennial</option>
		  <option value="4">Farrar Straus Giroux</option>
		  <option value="5">W. W. Norton and Company</option>
		  <option value="6">Putnam Pub Group</option>
		  <option value="7">Berkley Publishing Group</option>
		  <option value="8">Audioworks</option>
		  <option value="9">Random House</option>
		  <option value="10">Scribner</option>
		  <option value="11">Emblem Editions</option>
		  <option value="12">Citadel Press</option>
		  <option value="13">House of Anansi Press</option>
		  <option value="14">Mira Books</option>
		  <option value="15">Health Communications</option>
		  <option value="16">Brilliance Audio - Trade</option>
		  <option value="17">Kensington Publishing Corp.</option>
		  <option value="18">River City Pub</option>
		  <option value="19">Dell</option>
		  <option value="20">Plume</option>
		  <option value="21">Three Rivers Press</option>
		  <option value="22">Ryland Peters and Small Ltd</option>
		  <option value="23">Cypress House</option>
		  <option value="24">HarperEntertainment</option>
		  <option value="25">Scholastic</option>
		  <option value="26">Aladdin</option>
		  <option value="27">Too Far</option>
		  <option value="28">Ballantine Books</option>
		  <option value="29">Random House Trade Paperbacks</option>
		  <option value="30">Goldmann</option>
		  <option value="31">Alfred A. Knopf</option>
		  <option value="32">Little Brown and Company</option>
		  <option value="33">Harpercollins</option>
		  <option value="34">Avon</option>
		  <option value="35">Bantam</option>
		  <option value="36">Fireside</option>
		  <option value="37">HarperTorch</option>
		  <option value="38">Bantam Books</option>
		  <option value="39">Pocket</option>
		  <option value="40">Tor Books</option>
		  <option value="41">Tyndale House Publishers</option>
		  <option value="42">HarperCollins Publishers</option>
		  <option value="43">Harvest Books</option>
		  <option value="44">Chambers Harrap Publishers Ltd</option>
		  <option value="45">Avon Books</option>
		  <option value="46">Speed Graphics</option>
		  <option value="47">Sunflower Press</option>
		  <option value="48">Laurel Leaf</option>
		  <option value="49">Gallimard</option>
		  <option value="50">Prentice Hall (K-12)</option>
		  <option value="51">1stBooks Library</option>
		  <option value="52">Avon Trade</option>
		  <option value="53">Penguin Books</option>
		  <option value="54">Signet Book</option>
		  <option value="55">Thomas Nelson</option>
		  <option value="56">Ace Books</option>
		  <option value="57">Landoll</option>
		  <option value="58">Knopf</option>
		  <option value="59">Andrew Scott Publishers</option>
		  <option value="60">Atlantic Monthly Press</option>
		  <option value="63">Perennial</option>
		  <option value="64">McGraw-Hill</option>
		  <option value="65">Bantam Doubleday Dell</option>
		  <option value="66">Little, Brown</option>
		  <option value="67">Minotauro</option>
		  <option value="68">Distribooks</option>
		  <option value="69">Back Bay Books</option>
		  <option value="70">Doubleday Books</option>
		  <option value="71">Warner Books</option>
		  <option value="72">Vintage</option>
		  <option value="73">Hyperion</option>
		  <option value="74">Tusquets</option>
		  <option value="75">Star Trek</option>
		  <option value="76">Pocket Star</option>
		  <option value="77">Tor Books (Mm)</option>
		  <option value="79">Warner Books (Mm)</option>
		  <option value="80">Onyx Books</option>
		  <option value="81">Free Press</option>
		  <option value="82">Thomas Nelson Inc</option>
		  <option value="83">Edicoes Asa</option>
		  <option value="84">Pan Macmillan</option>
		  <option value="85">Anchor</option>
		  <option value="86">W.W. Norton and Company</option>
		  <option value="87">Arcadia Books</option>
		  <option value="88">John Hunt Publishing, Ltd.</option>
		  <option value="89">Fawcett Books</option>
		  <option value="90">Alianza</option>
		  <option value="91">Downtown Book Center</option>
		  <option value="92">Trafalgar Square</option>
		  <option value="93">Delta</option>
		  <option value="94">Laure Leaf</option>
		  <option value="95">Love Spell</option>
		  <option value="96">Penguin Books Ltd</option>
		  <option value="97">Roc</option>
		  <option value="98">Tor Fantasy</option>
		  <option value="99">Harpercollins Publisher</option>
		  <option value="100">Mariner Books</option>
		  <option value="101">Picador (UK)</option>
		  <option value="102">Dover Publications</option>
		  <option value="103">Simon Pulse</option>
		  <option value="104">Nelson Books</option>
		  <option value="105">Regal Books</option>
		  <option value="106">Del Rey Books</option>
		  <option value="107">Spectra</option>
		  <option value="109">Diogenes</option>
		  <option value="110">Diogenes Verlag</option>
		  <option value="111">Distribooks Inc</option>
		  <option value="113">Dtv</option>
		  <option value="115">Heyne</option>
		  <option value="116">Kiepenheuer and Witsch</option>
		  <option value="117">Piper</option>
		  <option value="118">Rowohlt, Reinbek</option>
		  <option value="119">Rowohlt Tb.</option>
		  <option value="120">Suhrkamp</option>
		  <option value="121">Ullstein Tb</option>
		  <option value="122">Fischer (Tb.), Frankfurt</option>
		  <option value="123">St Martins Pr</option>
		  <option value="124">Bantam Dell Pub Group</option>
		  <option value="125">Doubleday</option>
		  <option value="127">Island</option>
		  <option value="128">Warner Vision</option>
		  <option value="129">Plume Books</option>
		  <option value="130">Jove Books</option>
		  <option value="131">Atria</option>
		  <option value="132">University of Nebraska Press</option>
		  <option value="133">Ivy Books</option>
		  <option value="134">Regan Books</option>
		  <option value="135">Harcourt</option>
		  <option value="136">Vintage Books USA</option>
		  <option value="137">Dutton Books</option>
		  <option value="138">Delta Systems</option>
		  <option value="139">HarperFestival</option>
		  <option value="140">HarperPrism</option>
		  <option value="141">HarperTempest</option>
		  <option value="142">Orb Books</option>
		  <option value="143">Harlequin</option>
		  <option value="144">Modern Library</option>
		  <option value="145">Knopf Books for Young Readers</option>
		  <option value="146">William Morrow</option>
		  <option value="147">Wendy Lamb Books</option>
		  <option value="148">Random House Inc</option>
		  <option value="149">Push</option>
		  <option value="150">Signet Classics</option>
		  <option value="151">Signet</option>
		  <option value="152">Faber Faber Inc</option>
		  <option value="153">Viking Juvenile</option>
		  <option value="154">Simon and Schuster</option>
		  <option value="155">Touchstone</option>
		  <option value="156">Egmont Childrens Books</option>
		  <option value="157">Dreamhaven Books</option>
		  <option value="158">DC Comics</option>
		  <option value="159">Dark Horse Comics</option>
		  <option value="160">Alpha Books</option>
		  <option value="161">Farrar Straus and Giroux</option>
		  <option value="162">Dell Publishing Company</option>
		  <option value="163">Riverhead Books</option>
		  <option value="164">University of California Press</option>
		  <option value="165">Spectra Books</option>
		  <option value="166">Viking Books</option>
		  <option value="167">Hackett Pub Co Inc</option>
		  <option value="168">W W Norton and Co</option>
		  <option value="169">Washington Square Press</option>
		  <option value="170">Scholastic Paperbacks (Mm)</option>
		  <option value="171">Harpercollins Juvenile Books</option>
		  <option value="172">Starfire</option>
		  <option value="173">Last Knight Pub Co</option>
		  <option value="174">Del Rey</option>
		  <option value="175">Eos</option>
		  <option value="176">Columna</option>
		  <option value="177">Delacorte Press</option>
		  <option value="179">Quill (HarperCollins)</option>
		  <option value="180">Anagrama</option>
		  <option value="181">Douglas Gibson Books</option>
		  <option value="182">Arcade Publishing</option>
		  <option value="184">Access Press (HarperCollins)</option>
		  <option value="185">John Wiley and Sons Inc</option>
		  <option value="186">Penguin USA (Paper)</option>
		  <option value="187">Scribner Paper Fiction</option>
		  <option value="188">Pocket Books</option>
		  <option value="189">Readers Digest Assn</option>
		  <option value="190">Broadway Books</option>
		  <option value="191">F. H. Revell</option>
		  <option value="192">Baker Book House</option>
		  <option value="193">W Publishing Group</option>
		  <option value="194">NavPress</option>
		  <option value="195">Pub Group West</option>
		  <option value="196">YWAM Publishing</option>
		  <option value="197">F.J. Moody</option>
		  <option value="198">Emmaus Road Intl</option>
		  <option value="199">Puffin Books</option>
		  <option value="200">Castle Books</option>
		</select></td>
		</tr>
		<tr>
			<td>Genre : </td>
			<td><select name="Genre"  onmouseover="this.size = 10" onmouseout="this.size = 1">
			  <option value="0">Select Role</option>
			  <option value="1">Arts</option>
			  <option value="2">Photography</option>
			  <option value="3">Biographies</option>
			  <option value="4">Memoirs</option>
			  <option value="5">Business</option>
			  <option value="6">Children</option>
			  <option value="7">Christian</option>
			  <option value="8">Comics</option>
			  <option value="9">Computers</option>
			  <option value="10">Cookbooks</option>
			  <option value="11">Crafts</option>
			  <option value="12">Education</option>
			  <option value="13">Engineering</option>
			  <option value="14">Transportation</option>
			  <option value="15">Gay</option>
			  <option value="16">Health</option>
			  <option value="17">Humor</option>
			  <option value="18">Law</option>
			  <option value="19">Literature</option>
			  <option value="20">Medical</option>
			  <option value="21">Mystery</option>
			  <option value="22">Parenting</option>
			  <option value="23">Politics</option>
			  <option value="24">Social Sciences</option>
			  <option value="25">Spirituality</option>
			  <option value="26">Reference</option>
			  <option value="27">Romance</option>
			  <option value="28">Math</option>
			  <option value="29">Science Fiction</option>
			  <option value="30">Science</option>
			  <option value="31">Sports</option>
			  <option value="32">Travel</option>
			  <option value="33">Self-Help</option>
			</select></td>
			</tr>
			<tr>
				<td>Publication Date :</td>
				<td><input type="text" name='Publicationyear' placeholder="2015" required="required"/></td>
			</tr>
			<tr>
				<td>Price :</td> 
				<td><input  type="text" name='price' placeholder="999.99" required="required"/></td>
			</tr>
			<tr>
				<td>Language : </td>
				<td><select name="Language"  onmouseover="this.size = 10" onmouseout="this.size = 1">
			  <option value="0">Select Role</option>
			  <option value="1">Mandarin</option>
			  <option value="2">Spanish</option>
			  <option value="3">English</option>
			  <option value="4">Hindi</option>
			  <option value="5">Arabic</option>
			  <option value="6">Portuguese</option>
			  <option value="7">Bengali</option>
			  <option value="8">Russian</option>
			  <option value="9">Japanese</option>
			  <option value="10">Punjabi</option>
			  <option value="11">German</option>
			  <option value="12">Japanese</option>
			  <option value="13">Wu</option>
			  <option value="14">Malay</option>
			  <option value="16">Telugu</option>
			  <option value="17">Vietnamese</option>
			  <option value="18">Korean</option>
			  <option value="19">French</option>
			  <option value="20">Marathi</option>
			  <option value="21">Tamil</option>
			  <option value="22">Urdu</option>
			  <option value="23">Persian</option>
			  <option value="24">Turkish</option>
			  <option value="25">Italian</option>
			  <option value="26">Cantonese</option>
			  <option value="27">Thai</option>
			  <option value="28">Gujarati</option>
			  <option value="29">Jin</option>
			  <option value="30">Min Nan</option>
			  <option value="31">Polish</option>
			</select></td>
		</tr>
		<tr>
			<td>ISBN : </td>
			<td><input  type="text" name='ISBN' placeholder="999999999" required="required"/></td>
		</tr>
		<tr>
			<td>Inventory :</td>
			<td> <input  type="text" name='Inventory' placeholder="999" required="required"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="button" value="new Book"/></td>
		</tr>
		</table>
</form>
</body>
</html>