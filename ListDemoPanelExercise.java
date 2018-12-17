import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class ListDemoPanelExercise extends JPanel implements
ListSelectionListener
{
private JList songList;
private Song songCollection[] = new Song[ 5 ];
private String songNames[] = new String[ 5 ];
private JTextField artistNameField;
public ListDemoPanelExercise()
{
// Fill song array
songCollection = getSongs();
// Fill song name array
songNames = getSongNames();
// Create a list for songs
songList = new JList( songNames );
// Set list properties
songList.setFixedCellWidth( 200 );
songList.setVisibleRowCount( 3 );
songList.setSelectedIndex( 0 );
songList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
// Create a Scroll pane
JScrollPane scrollableList = new JScrollPane( songList );
// Register as listener
songList.addListSelectionListener( this );
// Create a Label & text field for artist name
JLabel artistNameLabel = new JLabel( "Artist Name: " );
artistNameField = new JTextField( 10 );
// Add name to a panel
JPanel namePanel = new JPanel();
namePanel.add( artistNameLabel );
namePanel.add( artistNameField );
// Add list & name field to main panel
this.add( scrollableList );
this.add( namePanel );
}
public Song[] getSongs()
{
Song [] array = new Song[ 5 ];
array[ 0 ] = new Song( "Grenade", "Bruno Mars",
"Doo-Wops & Hooligans" );
array[ 1 ] = new Song( "Firework", "Katy Perry",
"Teenage Dream" );
array[ 2 ] = new Song( "Just a Dream", "Nelly",
"Just a Dream (single)" );
array[ 3 ] = new Song( "Mine", "Taylor Swift", "Speak Now" );
array[ 4 ] = new Song( "Mama's Song", "Carrie Underwood",
"Play On" );
return array;
}
public String[] getSongNames()
{
String [] names = new String[ 5 ];
for( int i = 0; i < 5; i++ )
names[ i ] = songCollection[ i ].getSongName();
return names;
}
public void valueChanged( ListSelectionEvent e )
{
Object source = e.getSource();
int index = songList.getSelectedIndex();
Song selection = songCollection[ index ];
if ( source == songList )
{
artistNameField.setText( selection.getArtistName() );
}
}
}