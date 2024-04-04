package org.xtext.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Root'", "'{'", "'character_sheet'", "'world_concepts'", "'location_sheet'", "'political_entity_sheet'", "'belief_system_sheet'", "'event_sheet'", "'presence_sheet'", "'}'", "'CharacterSheet'", "'character'", "','", "'WorldConcepts'", "'defaultAnimalSpecies'", "'animalspeciestype'", "'plantspeciestype'", "'locationtype'", "'beliefsystemtype'", "'relationshiptype'", "'LocationSheet'", "'location'", "'PoliticalEntitySheet'", "'politicalentity'", "'BeliefSystemSheet'", "'beliefsystem'", "'EventSheet'", "'event'", "'PresenceSheet'", "'presence'", "'Character'", "'description'", "'first_name'", "'last_name'", "'occupation'", "'children'", "'('", "')'", "'believes'", "'supports'", "'birth'", "'death'", "'relationship'", "'Timestamp'", "'year'", "'month'", "'day'", "'hour'", "'minute'", "'second'", "'Relationship'", "'BeliefSystem'", "'is_believed_by'", "'related_events'", "'PoliticalEntity'", "'members'", "'is_concerned_with'", "'AnimalSpeciesType'", "'natural_habitat'", "'-'", "'RelationshipType'", "'canHaveEvent'", "'BeliefSystemType'", "'Event'", "'presences'", "'related_beliefs'", "'Location'", "'flag'", "'plants_that_occur'", "'animals_that_occur'", "'events'", "'coordinates'", "'Presence'", "'timeframe'", "'ImageURL'", "'LocationType'", "'contains'", "'PlantSpeciesType'", "'Coordinate'", "'latitude'", "'longitude'", "'.'", "'E'", "'e'", "'Timeframe'", "'start'", "'end'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Root";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRoot"
    // InternalMyDsl.g:64:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // InternalMyDsl.g:64:45: (iv_ruleRoot= ruleRoot EOF )
            // InternalMyDsl.g:65:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // InternalMyDsl.g:71:1: ruleRoot returns [EObject current=null] : (otherlv_0= 'Root' otherlv_1= '{' otherlv_2= 'character_sheet' ( (lv_character_sheet_3_0= ruleCharacterSheet ) ) otherlv_4= 'world_concepts' ( (lv_world_concepts_5_0= ruleWorldConcepts ) ) (otherlv_6= 'location_sheet' ( (lv_location_sheet_7_0= ruleLocationSheet ) ) )? otherlv_8= 'political_entity_sheet' ( (lv_political_entity_sheet_9_0= rulePoliticalEntitySheet ) ) otherlv_10= 'belief_system_sheet' ( (lv_belief_system_sheet_11_0= ruleBeliefSystemSheet ) ) otherlv_12= 'event_sheet' ( (lv_event_sheet_13_0= ruleEventSheet ) ) otherlv_14= 'presence_sheet' ( (lv_presence_sheet_15_0= rulePresenceSheet ) ) otherlv_16= '}' ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_character_sheet_3_0 = null;

        EObject lv_world_concepts_5_0 = null;

        EObject lv_location_sheet_7_0 = null;

        EObject lv_political_entity_sheet_9_0 = null;

        EObject lv_belief_system_sheet_11_0 = null;

        EObject lv_event_sheet_13_0 = null;

        EObject lv_presence_sheet_15_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:77:2: ( (otherlv_0= 'Root' otherlv_1= '{' otherlv_2= 'character_sheet' ( (lv_character_sheet_3_0= ruleCharacterSheet ) ) otherlv_4= 'world_concepts' ( (lv_world_concepts_5_0= ruleWorldConcepts ) ) (otherlv_6= 'location_sheet' ( (lv_location_sheet_7_0= ruleLocationSheet ) ) )? otherlv_8= 'political_entity_sheet' ( (lv_political_entity_sheet_9_0= rulePoliticalEntitySheet ) ) otherlv_10= 'belief_system_sheet' ( (lv_belief_system_sheet_11_0= ruleBeliefSystemSheet ) ) otherlv_12= 'event_sheet' ( (lv_event_sheet_13_0= ruleEventSheet ) ) otherlv_14= 'presence_sheet' ( (lv_presence_sheet_15_0= rulePresenceSheet ) ) otherlv_16= '}' ) )
            // InternalMyDsl.g:78:2: (otherlv_0= 'Root' otherlv_1= '{' otherlv_2= 'character_sheet' ( (lv_character_sheet_3_0= ruleCharacterSheet ) ) otherlv_4= 'world_concepts' ( (lv_world_concepts_5_0= ruleWorldConcepts ) ) (otherlv_6= 'location_sheet' ( (lv_location_sheet_7_0= ruleLocationSheet ) ) )? otherlv_8= 'political_entity_sheet' ( (lv_political_entity_sheet_9_0= rulePoliticalEntitySheet ) ) otherlv_10= 'belief_system_sheet' ( (lv_belief_system_sheet_11_0= ruleBeliefSystemSheet ) ) otherlv_12= 'event_sheet' ( (lv_event_sheet_13_0= ruleEventSheet ) ) otherlv_14= 'presence_sheet' ( (lv_presence_sheet_15_0= rulePresenceSheet ) ) otherlv_16= '}' )
            {
            // InternalMyDsl.g:78:2: (otherlv_0= 'Root' otherlv_1= '{' otherlv_2= 'character_sheet' ( (lv_character_sheet_3_0= ruleCharacterSheet ) ) otherlv_4= 'world_concepts' ( (lv_world_concepts_5_0= ruleWorldConcepts ) ) (otherlv_6= 'location_sheet' ( (lv_location_sheet_7_0= ruleLocationSheet ) ) )? otherlv_8= 'political_entity_sheet' ( (lv_political_entity_sheet_9_0= rulePoliticalEntitySheet ) ) otherlv_10= 'belief_system_sheet' ( (lv_belief_system_sheet_11_0= ruleBeliefSystemSheet ) ) otherlv_12= 'event_sheet' ( (lv_event_sheet_13_0= ruleEventSheet ) ) otherlv_14= 'presence_sheet' ( (lv_presence_sheet_15_0= rulePresenceSheet ) ) otherlv_16= '}' )
            // InternalMyDsl.g:79:3: otherlv_0= 'Root' otherlv_1= '{' otherlv_2= 'character_sheet' ( (lv_character_sheet_3_0= ruleCharacterSheet ) ) otherlv_4= 'world_concepts' ( (lv_world_concepts_5_0= ruleWorldConcepts ) ) (otherlv_6= 'location_sheet' ( (lv_location_sheet_7_0= ruleLocationSheet ) ) )? otherlv_8= 'political_entity_sheet' ( (lv_political_entity_sheet_9_0= rulePoliticalEntitySheet ) ) otherlv_10= 'belief_system_sheet' ( (lv_belief_system_sheet_11_0= ruleBeliefSystemSheet ) ) otherlv_12= 'event_sheet' ( (lv_event_sheet_13_0= ruleEventSheet ) ) otherlv_14= 'presence_sheet' ( (lv_presence_sheet_15_0= rulePresenceSheet ) ) otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRootAccess().getRootKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getRootAccess().getCharacter_sheetKeyword_2());
            		
            // InternalMyDsl.g:91:3: ( (lv_character_sheet_3_0= ruleCharacterSheet ) )
            // InternalMyDsl.g:92:4: (lv_character_sheet_3_0= ruleCharacterSheet )
            {
            // InternalMyDsl.g:92:4: (lv_character_sheet_3_0= ruleCharacterSheet )
            // InternalMyDsl.g:93:5: lv_character_sheet_3_0= ruleCharacterSheet
            {

            					newCompositeNode(grammarAccess.getRootAccess().getCharacter_sheetCharacterSheetParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_character_sheet_3_0=ruleCharacterSheet();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRootRule());
            					}
            					set(
            						current,
            						"character_sheet",
            						lv_character_sheet_3_0,
            						"org.xtext.mydsl.MyDsl.CharacterSheet");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getRootAccess().getWorld_conceptsKeyword_4());
            		
            // InternalMyDsl.g:114:3: ( (lv_world_concepts_5_0= ruleWorldConcepts ) )
            // InternalMyDsl.g:115:4: (lv_world_concepts_5_0= ruleWorldConcepts )
            {
            // InternalMyDsl.g:115:4: (lv_world_concepts_5_0= ruleWorldConcepts )
            // InternalMyDsl.g:116:5: lv_world_concepts_5_0= ruleWorldConcepts
            {

            					newCompositeNode(grammarAccess.getRootAccess().getWorld_conceptsWorldConceptsParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_8);
            lv_world_concepts_5_0=ruleWorldConcepts();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRootRule());
            					}
            					set(
            						current,
            						"world_concepts",
            						lv_world_concepts_5_0,
            						"org.xtext.mydsl.MyDsl.WorldConcepts");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:133:3: (otherlv_6= 'location_sheet' ( (lv_location_sheet_7_0= ruleLocationSheet ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalMyDsl.g:134:4: otherlv_6= 'location_sheet' ( (lv_location_sheet_7_0= ruleLocationSheet ) )
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_9); 

                    				newLeafNode(otherlv_6, grammarAccess.getRootAccess().getLocation_sheetKeyword_6_0());
                    			
                    // InternalMyDsl.g:138:4: ( (lv_location_sheet_7_0= ruleLocationSheet ) )
                    // InternalMyDsl.g:139:5: (lv_location_sheet_7_0= ruleLocationSheet )
                    {
                    // InternalMyDsl.g:139:5: (lv_location_sheet_7_0= ruleLocationSheet )
                    // InternalMyDsl.g:140:6: lv_location_sheet_7_0= ruleLocationSheet
                    {

                    						newCompositeNode(grammarAccess.getRootAccess().getLocation_sheetLocationSheetParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_location_sheet_7_0=ruleLocationSheet();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRootRule());
                    						}
                    						set(
                    							current,
                    							"location_sheet",
                    							lv_location_sheet_7_0,
                    							"org.xtext.mydsl.MyDsl.LocationSheet");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_8, grammarAccess.getRootAccess().getPolitical_entity_sheetKeyword_7());
            		
            // InternalMyDsl.g:162:3: ( (lv_political_entity_sheet_9_0= rulePoliticalEntitySheet ) )
            // InternalMyDsl.g:163:4: (lv_political_entity_sheet_9_0= rulePoliticalEntitySheet )
            {
            // InternalMyDsl.g:163:4: (lv_political_entity_sheet_9_0= rulePoliticalEntitySheet )
            // InternalMyDsl.g:164:5: lv_political_entity_sheet_9_0= rulePoliticalEntitySheet
            {

            					newCompositeNode(grammarAccess.getRootAccess().getPolitical_entity_sheetPoliticalEntitySheetParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_12);
            lv_political_entity_sheet_9_0=rulePoliticalEntitySheet();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRootRule());
            					}
            					set(
            						current,
            						"political_entity_sheet",
            						lv_political_entity_sheet_9_0,
            						"org.xtext.mydsl.MyDsl.PoliticalEntitySheet");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,17,FOLLOW_13); 

            			newLeafNode(otherlv_10, grammarAccess.getRootAccess().getBelief_system_sheetKeyword_9());
            		
            // InternalMyDsl.g:185:3: ( (lv_belief_system_sheet_11_0= ruleBeliefSystemSheet ) )
            // InternalMyDsl.g:186:4: (lv_belief_system_sheet_11_0= ruleBeliefSystemSheet )
            {
            // InternalMyDsl.g:186:4: (lv_belief_system_sheet_11_0= ruleBeliefSystemSheet )
            // InternalMyDsl.g:187:5: lv_belief_system_sheet_11_0= ruleBeliefSystemSheet
            {

            					newCompositeNode(grammarAccess.getRootAccess().getBelief_system_sheetBeliefSystemSheetParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_14);
            lv_belief_system_sheet_11_0=ruleBeliefSystemSheet();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRootRule());
            					}
            					set(
            						current,
            						"belief_system_sheet",
            						lv_belief_system_sheet_11_0,
            						"org.xtext.mydsl.MyDsl.BeliefSystemSheet");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,18,FOLLOW_15); 

            			newLeafNode(otherlv_12, grammarAccess.getRootAccess().getEvent_sheetKeyword_11());
            		
            // InternalMyDsl.g:208:3: ( (lv_event_sheet_13_0= ruleEventSheet ) )
            // InternalMyDsl.g:209:4: (lv_event_sheet_13_0= ruleEventSheet )
            {
            // InternalMyDsl.g:209:4: (lv_event_sheet_13_0= ruleEventSheet )
            // InternalMyDsl.g:210:5: lv_event_sheet_13_0= ruleEventSheet
            {

            					newCompositeNode(grammarAccess.getRootAccess().getEvent_sheetEventSheetParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_16);
            lv_event_sheet_13_0=ruleEventSheet();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRootRule());
            					}
            					set(
            						current,
            						"event_sheet",
            						lv_event_sheet_13_0,
            						"org.xtext.mydsl.MyDsl.EventSheet");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,19,FOLLOW_17); 

            			newLeafNode(otherlv_14, grammarAccess.getRootAccess().getPresence_sheetKeyword_13());
            		
            // InternalMyDsl.g:231:3: ( (lv_presence_sheet_15_0= rulePresenceSheet ) )
            // InternalMyDsl.g:232:4: (lv_presence_sheet_15_0= rulePresenceSheet )
            {
            // InternalMyDsl.g:232:4: (lv_presence_sheet_15_0= rulePresenceSheet )
            // InternalMyDsl.g:233:5: lv_presence_sheet_15_0= rulePresenceSheet
            {

            					newCompositeNode(grammarAccess.getRootAccess().getPresence_sheetPresenceSheetParserRuleCall_14_0());
            				
            pushFollow(FOLLOW_18);
            lv_presence_sheet_15_0=rulePresenceSheet();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRootRule());
            					}
            					set(
            						current,
            						"presence_sheet",
            						lv_presence_sheet_15_0,
            						"org.xtext.mydsl.MyDsl.PresenceSheet");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_16=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getRootAccess().getRightCurlyBracketKeyword_15());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleCharacterSheet"
    // InternalMyDsl.g:258:1: entryRuleCharacterSheet returns [EObject current=null] : iv_ruleCharacterSheet= ruleCharacterSheet EOF ;
    public final EObject entryRuleCharacterSheet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterSheet = null;


        try {
            // InternalMyDsl.g:258:55: (iv_ruleCharacterSheet= ruleCharacterSheet EOF )
            // InternalMyDsl.g:259:2: iv_ruleCharacterSheet= ruleCharacterSheet EOF
            {
             newCompositeNode(grammarAccess.getCharacterSheetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCharacterSheet=ruleCharacterSheet();

            state._fsp--;

             current =iv_ruleCharacterSheet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCharacterSheet"


    // $ANTLR start "ruleCharacterSheet"
    // InternalMyDsl.g:265:1: ruleCharacterSheet returns [EObject current=null] : ( () otherlv_1= 'CharacterSheet' otherlv_2= '{' (otherlv_3= 'character' otherlv_4= '{' ( (lv_character_5_0= ruleCharacter ) ) (otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleCharacterSheet() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_character_5_0 = null;

        EObject lv_character_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:271:2: ( ( () otherlv_1= 'CharacterSheet' otherlv_2= '{' (otherlv_3= 'character' otherlv_4= '{' ( (lv_character_5_0= ruleCharacter ) ) (otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:272:2: ( () otherlv_1= 'CharacterSheet' otherlv_2= '{' (otherlv_3= 'character' otherlv_4= '{' ( (lv_character_5_0= ruleCharacter ) ) (otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:272:2: ( () otherlv_1= 'CharacterSheet' otherlv_2= '{' (otherlv_3= 'character' otherlv_4= '{' ( (lv_character_5_0= ruleCharacter ) ) (otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:273:3: () otherlv_1= 'CharacterSheet' otherlv_2= '{' (otherlv_3= 'character' otherlv_4= '{' ( (lv_character_5_0= ruleCharacter ) ) (otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:273:3: ()
            // InternalMyDsl.g:274:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCharacterSheetAccess().getCharacterSheetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCharacterSheetAccess().getCharacterSheetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getCharacterSheetAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:288:3: (otherlv_3= 'character' otherlv_4= '{' ( (lv_character_5_0= ruleCharacter ) ) (otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) ) )* otherlv_8= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==22) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalMyDsl.g:289:4: otherlv_3= 'character' otherlv_4= '{' ( (lv_character_5_0= ruleCharacter ) ) (otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getCharacterSheetAccess().getCharacterKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_20); 

                    				newLeafNode(otherlv_4, grammarAccess.getCharacterSheetAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:297:4: ( (lv_character_5_0= ruleCharacter ) )
                    // InternalMyDsl.g:298:5: (lv_character_5_0= ruleCharacter )
                    {
                    // InternalMyDsl.g:298:5: (lv_character_5_0= ruleCharacter )
                    // InternalMyDsl.g:299:6: lv_character_5_0= ruleCharacter
                    {

                    						newCompositeNode(grammarAccess.getCharacterSheetAccess().getCharacterCharacterParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_character_5_0=ruleCharacter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterSheetRule());
                    						}
                    						add(
                    							current,
                    							"character",
                    							lv_character_5_0,
                    							"org.xtext.mydsl.MyDsl.Character");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:316:4: (otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==23) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalMyDsl.g:317:5: otherlv_6= ',' ( (lv_character_7_0= ruleCharacter ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_20); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getCharacterSheetAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:321:5: ( (lv_character_7_0= ruleCharacter ) )
                    	    // InternalMyDsl.g:322:6: (lv_character_7_0= ruleCharacter )
                    	    {
                    	    // InternalMyDsl.g:322:6: (lv_character_7_0= ruleCharacter )
                    	    // InternalMyDsl.g:323:7: lv_character_7_0= ruleCharacter
                    	    {

                    	    							newCompositeNode(grammarAccess.getCharacterSheetAccess().getCharacterCharacterParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_character_7_0=ruleCharacter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCharacterSheetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"character",
                    	    								lv_character_7_0,
                    	    								"org.xtext.mydsl.MyDsl.Character");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getCharacterSheetAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getCharacterSheetAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCharacterSheet"


    // $ANTLR start "entryRuleWorldConcepts"
    // InternalMyDsl.g:354:1: entryRuleWorldConcepts returns [EObject current=null] : iv_ruleWorldConcepts= ruleWorldConcepts EOF ;
    public final EObject entryRuleWorldConcepts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorldConcepts = null;


        try {
            // InternalMyDsl.g:354:54: (iv_ruleWorldConcepts= ruleWorldConcepts EOF )
            // InternalMyDsl.g:355:2: iv_ruleWorldConcepts= ruleWorldConcepts EOF
            {
             newCompositeNode(grammarAccess.getWorldConceptsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorldConcepts=ruleWorldConcepts();

            state._fsp--;

             current =iv_ruleWorldConcepts; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorldConcepts"


    // $ANTLR start "ruleWorldConcepts"
    // InternalMyDsl.g:361:1: ruleWorldConcepts returns [EObject current=null] : (otherlv_0= 'WorldConcepts' otherlv_1= '{' otherlv_2= 'defaultAnimalSpecies' ( ( ruleEString ) ) (otherlv_4= 'animalspeciestype' otherlv_5= '{' ( (lv_animalspeciestype_6_0= ruleAnimalSpeciesType ) ) (otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) ) )* otherlv_9= '}' )? (otherlv_10= 'plantspeciestype' otherlv_11= '{' ( (lv_plantspeciestype_12_0= rulePlantSpeciesType ) ) (otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) ) )* otherlv_15= '}' )? (otherlv_16= 'locationtype' otherlv_17= '{' ( (lv_locationtype_18_0= ruleLocationType ) ) (otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) ) )* otherlv_21= '}' )? (otherlv_22= 'beliefsystemtype' otherlv_23= '{' ( (lv_beliefsystemtype_24_0= ruleBeliefSystemType ) ) (otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) ) )* otherlv_27= '}' )? (otherlv_28= 'relationshiptype' otherlv_29= '{' ( (lv_relationshiptype_30_0= ruleRelationshipType ) ) (otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) ) )* otherlv_33= '}' )? otherlv_34= '}' ) ;
    public final EObject ruleWorldConcepts() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        EObject lv_animalspeciestype_6_0 = null;

        EObject lv_animalspeciestype_8_0 = null;

        EObject lv_plantspeciestype_12_0 = null;

        EObject lv_plantspeciestype_14_0 = null;

        EObject lv_locationtype_18_0 = null;

        EObject lv_locationtype_20_0 = null;

        EObject lv_beliefsystemtype_24_0 = null;

        EObject lv_beliefsystemtype_26_0 = null;

        EObject lv_relationshiptype_30_0 = null;

        EObject lv_relationshiptype_32_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:367:2: ( (otherlv_0= 'WorldConcepts' otherlv_1= '{' otherlv_2= 'defaultAnimalSpecies' ( ( ruleEString ) ) (otherlv_4= 'animalspeciestype' otherlv_5= '{' ( (lv_animalspeciestype_6_0= ruleAnimalSpeciesType ) ) (otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) ) )* otherlv_9= '}' )? (otherlv_10= 'plantspeciestype' otherlv_11= '{' ( (lv_plantspeciestype_12_0= rulePlantSpeciesType ) ) (otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) ) )* otherlv_15= '}' )? (otherlv_16= 'locationtype' otherlv_17= '{' ( (lv_locationtype_18_0= ruleLocationType ) ) (otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) ) )* otherlv_21= '}' )? (otherlv_22= 'beliefsystemtype' otherlv_23= '{' ( (lv_beliefsystemtype_24_0= ruleBeliefSystemType ) ) (otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) ) )* otherlv_27= '}' )? (otherlv_28= 'relationshiptype' otherlv_29= '{' ( (lv_relationshiptype_30_0= ruleRelationshipType ) ) (otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) ) )* otherlv_33= '}' )? otherlv_34= '}' ) )
            // InternalMyDsl.g:368:2: (otherlv_0= 'WorldConcepts' otherlv_1= '{' otherlv_2= 'defaultAnimalSpecies' ( ( ruleEString ) ) (otherlv_4= 'animalspeciestype' otherlv_5= '{' ( (lv_animalspeciestype_6_0= ruleAnimalSpeciesType ) ) (otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) ) )* otherlv_9= '}' )? (otherlv_10= 'plantspeciestype' otherlv_11= '{' ( (lv_plantspeciestype_12_0= rulePlantSpeciesType ) ) (otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) ) )* otherlv_15= '}' )? (otherlv_16= 'locationtype' otherlv_17= '{' ( (lv_locationtype_18_0= ruleLocationType ) ) (otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) ) )* otherlv_21= '}' )? (otherlv_22= 'beliefsystemtype' otherlv_23= '{' ( (lv_beliefsystemtype_24_0= ruleBeliefSystemType ) ) (otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) ) )* otherlv_27= '}' )? (otherlv_28= 'relationshiptype' otherlv_29= '{' ( (lv_relationshiptype_30_0= ruleRelationshipType ) ) (otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) ) )* otherlv_33= '}' )? otherlv_34= '}' )
            {
            // InternalMyDsl.g:368:2: (otherlv_0= 'WorldConcepts' otherlv_1= '{' otherlv_2= 'defaultAnimalSpecies' ( ( ruleEString ) ) (otherlv_4= 'animalspeciestype' otherlv_5= '{' ( (lv_animalspeciestype_6_0= ruleAnimalSpeciesType ) ) (otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) ) )* otherlv_9= '}' )? (otherlv_10= 'plantspeciestype' otherlv_11= '{' ( (lv_plantspeciestype_12_0= rulePlantSpeciesType ) ) (otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) ) )* otherlv_15= '}' )? (otherlv_16= 'locationtype' otherlv_17= '{' ( (lv_locationtype_18_0= ruleLocationType ) ) (otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) ) )* otherlv_21= '}' )? (otherlv_22= 'beliefsystemtype' otherlv_23= '{' ( (lv_beliefsystemtype_24_0= ruleBeliefSystemType ) ) (otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) ) )* otherlv_27= '}' )? (otherlv_28= 'relationshiptype' otherlv_29= '{' ( (lv_relationshiptype_30_0= ruleRelationshipType ) ) (otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) ) )* otherlv_33= '}' )? otherlv_34= '}' )
            // InternalMyDsl.g:369:3: otherlv_0= 'WorldConcepts' otherlv_1= '{' otherlv_2= 'defaultAnimalSpecies' ( ( ruleEString ) ) (otherlv_4= 'animalspeciestype' otherlv_5= '{' ( (lv_animalspeciestype_6_0= ruleAnimalSpeciesType ) ) (otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) ) )* otherlv_9= '}' )? (otherlv_10= 'plantspeciestype' otherlv_11= '{' ( (lv_plantspeciestype_12_0= rulePlantSpeciesType ) ) (otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) ) )* otherlv_15= '}' )? (otherlv_16= 'locationtype' otherlv_17= '{' ( (lv_locationtype_18_0= ruleLocationType ) ) (otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) ) )* otherlv_21= '}' )? (otherlv_22= 'beliefsystemtype' otherlv_23= '{' ( (lv_beliefsystemtype_24_0= ruleBeliefSystemType ) ) (otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) ) )* otherlv_27= '}' )? (otherlv_28= 'relationshiptype' otherlv_29= '{' ( (lv_relationshiptype_30_0= ruleRelationshipType ) ) (otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) ) )* otherlv_33= '}' )? otherlv_34= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWorldConceptsAccess().getWorldConceptsKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getWorldConceptsAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getWorldConceptsAccess().getDefaultAnimalSpeciesKeyword_2());
            		
            // InternalMyDsl.g:381:3: ( ( ruleEString ) )
            // InternalMyDsl.g:382:4: ( ruleEString )
            {
            // InternalMyDsl.g:382:4: ( ruleEString )
            // InternalMyDsl.g:383:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorldConceptsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWorldConceptsAccess().getDefaultAnimalSpeciesAnimalSpeciesTypeCrossReference_3_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:397:3: (otherlv_4= 'animalspeciestype' otherlv_5= '{' ( (lv_animalspeciestype_6_0= ruleAnimalSpeciesType ) ) (otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) ) )* otherlv_9= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==26) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMyDsl.g:398:4: otherlv_4= 'animalspeciestype' otherlv_5= '{' ( (lv_animalspeciestype_6_0= ruleAnimalSpeciesType ) ) (otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getWorldConceptsAccess().getAnimalspeciestypeKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,12,FOLLOW_25); 

                    				newLeafNode(otherlv_5, grammarAccess.getWorldConceptsAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMyDsl.g:406:4: ( (lv_animalspeciestype_6_0= ruleAnimalSpeciesType ) )
                    // InternalMyDsl.g:407:5: (lv_animalspeciestype_6_0= ruleAnimalSpeciesType )
                    {
                    // InternalMyDsl.g:407:5: (lv_animalspeciestype_6_0= ruleAnimalSpeciesType )
                    // InternalMyDsl.g:408:6: lv_animalspeciestype_6_0= ruleAnimalSpeciesType
                    {

                    						newCompositeNode(grammarAccess.getWorldConceptsAccess().getAnimalspeciestypeAnimalSpeciesTypeParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_animalspeciestype_6_0=ruleAnimalSpeciesType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    						}
                    						add(
                    							current,
                    							"animalspeciestype",
                    							lv_animalspeciestype_6_0,
                    							"org.xtext.mydsl.MyDsl.AnimalSpeciesType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:425:4: (otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==23) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalMyDsl.g:426:5: otherlv_7= ',' ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) )
                    	    {
                    	    otherlv_7=(Token)match(input,23,FOLLOW_25); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getWorldConceptsAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalMyDsl.g:430:5: ( (lv_animalspeciestype_8_0= ruleAnimalSpeciesType ) )
                    	    // InternalMyDsl.g:431:6: (lv_animalspeciestype_8_0= ruleAnimalSpeciesType )
                    	    {
                    	    // InternalMyDsl.g:431:6: (lv_animalspeciestype_8_0= ruleAnimalSpeciesType )
                    	    // InternalMyDsl.g:432:7: lv_animalspeciestype_8_0= ruleAnimalSpeciesType
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorldConceptsAccess().getAnimalspeciestypeAnimalSpeciesTypeParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_animalspeciestype_8_0=ruleAnimalSpeciesType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"animalspeciestype",
                    	    								lv_animalspeciestype_8_0,
                    	    								"org.xtext.mydsl.MyDsl.AnimalSpeciesType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,20,FOLLOW_26); 

                    				newLeafNode(otherlv_9, grammarAccess.getWorldConceptsAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:455:3: (otherlv_10= 'plantspeciestype' otherlv_11= '{' ( (lv_plantspeciestype_12_0= rulePlantSpeciesType ) ) (otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) ) )* otherlv_15= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMyDsl.g:456:4: otherlv_10= 'plantspeciestype' otherlv_11= '{' ( (lv_plantspeciestype_12_0= rulePlantSpeciesType ) ) (otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) ) )* otherlv_15= '}'
                    {
                    otherlv_10=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getWorldConceptsAccess().getPlantspeciestypeKeyword_5_0());
                    			
                    otherlv_11=(Token)match(input,12,FOLLOW_27); 

                    				newLeafNode(otherlv_11, grammarAccess.getWorldConceptsAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMyDsl.g:464:4: ( (lv_plantspeciestype_12_0= rulePlantSpeciesType ) )
                    // InternalMyDsl.g:465:5: (lv_plantspeciestype_12_0= rulePlantSpeciesType )
                    {
                    // InternalMyDsl.g:465:5: (lv_plantspeciestype_12_0= rulePlantSpeciesType )
                    // InternalMyDsl.g:466:6: lv_plantspeciestype_12_0= rulePlantSpeciesType
                    {

                    						newCompositeNode(grammarAccess.getWorldConceptsAccess().getPlantspeciestypePlantSpeciesTypeParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_plantspeciestype_12_0=rulePlantSpeciesType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    						}
                    						add(
                    							current,
                    							"plantspeciestype",
                    							lv_plantspeciestype_12_0,
                    							"org.xtext.mydsl.MyDsl.PlantSpeciesType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:483:4: (otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==23) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalMyDsl.g:484:5: otherlv_13= ',' ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) )
                    	    {
                    	    otherlv_13=(Token)match(input,23,FOLLOW_27); 

                    	    					newLeafNode(otherlv_13, grammarAccess.getWorldConceptsAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalMyDsl.g:488:5: ( (lv_plantspeciestype_14_0= rulePlantSpeciesType ) )
                    	    // InternalMyDsl.g:489:6: (lv_plantspeciestype_14_0= rulePlantSpeciesType )
                    	    {
                    	    // InternalMyDsl.g:489:6: (lv_plantspeciestype_14_0= rulePlantSpeciesType )
                    	    // InternalMyDsl.g:490:7: lv_plantspeciestype_14_0= rulePlantSpeciesType
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorldConceptsAccess().getPlantspeciestypePlantSpeciesTypeParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_plantspeciestype_14_0=rulePlantSpeciesType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"plantspeciestype",
                    	    								lv_plantspeciestype_14_0,
                    	    								"org.xtext.mydsl.MyDsl.PlantSpeciesType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,20,FOLLOW_28); 

                    				newLeafNode(otherlv_15, grammarAccess.getWorldConceptsAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:513:3: (otherlv_16= 'locationtype' otherlv_17= '{' ( (lv_locationtype_18_0= ruleLocationType ) ) (otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) ) )* otherlv_21= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==28) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:514:4: otherlv_16= 'locationtype' otherlv_17= '{' ( (lv_locationtype_18_0= ruleLocationType ) ) (otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) ) )* otherlv_21= '}'
                    {
                    otherlv_16=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getWorldConceptsAccess().getLocationtypeKeyword_6_0());
                    			
                    otherlv_17=(Token)match(input,12,FOLLOW_29); 

                    				newLeafNode(otherlv_17, grammarAccess.getWorldConceptsAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMyDsl.g:522:4: ( (lv_locationtype_18_0= ruleLocationType ) )
                    // InternalMyDsl.g:523:5: (lv_locationtype_18_0= ruleLocationType )
                    {
                    // InternalMyDsl.g:523:5: (lv_locationtype_18_0= ruleLocationType )
                    // InternalMyDsl.g:524:6: lv_locationtype_18_0= ruleLocationType
                    {

                    						newCompositeNode(grammarAccess.getWorldConceptsAccess().getLocationtypeLocationTypeParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_locationtype_18_0=ruleLocationType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    						}
                    						add(
                    							current,
                    							"locationtype",
                    							lv_locationtype_18_0,
                    							"org.xtext.mydsl.MyDsl.LocationType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:541:4: (otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==23) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalMyDsl.g:542:5: otherlv_19= ',' ( (lv_locationtype_20_0= ruleLocationType ) )
                    	    {
                    	    otherlv_19=(Token)match(input,23,FOLLOW_29); 

                    	    					newLeafNode(otherlv_19, grammarAccess.getWorldConceptsAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMyDsl.g:546:5: ( (lv_locationtype_20_0= ruleLocationType ) )
                    	    // InternalMyDsl.g:547:6: (lv_locationtype_20_0= ruleLocationType )
                    	    {
                    	    // InternalMyDsl.g:547:6: (lv_locationtype_20_0= ruleLocationType )
                    	    // InternalMyDsl.g:548:7: lv_locationtype_20_0= ruleLocationType
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorldConceptsAccess().getLocationtypeLocationTypeParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_locationtype_20_0=ruleLocationType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"locationtype",
                    	    								lv_locationtype_20_0,
                    	    								"org.xtext.mydsl.MyDsl.LocationType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,20,FOLLOW_30); 

                    				newLeafNode(otherlv_21, grammarAccess.getWorldConceptsAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:571:3: (otherlv_22= 'beliefsystemtype' otherlv_23= '{' ( (lv_beliefsystemtype_24_0= ruleBeliefSystemType ) ) (otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) ) )* otherlv_27= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:572:4: otherlv_22= 'beliefsystemtype' otherlv_23= '{' ( (lv_beliefsystemtype_24_0= ruleBeliefSystemType ) ) (otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) ) )* otherlv_27= '}'
                    {
                    otherlv_22=(Token)match(input,29,FOLLOW_3); 

                    				newLeafNode(otherlv_22, grammarAccess.getWorldConceptsAccess().getBeliefsystemtypeKeyword_7_0());
                    			
                    otherlv_23=(Token)match(input,12,FOLLOW_31); 

                    				newLeafNode(otherlv_23, grammarAccess.getWorldConceptsAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalMyDsl.g:580:4: ( (lv_beliefsystemtype_24_0= ruleBeliefSystemType ) )
                    // InternalMyDsl.g:581:5: (lv_beliefsystemtype_24_0= ruleBeliefSystemType )
                    {
                    // InternalMyDsl.g:581:5: (lv_beliefsystemtype_24_0= ruleBeliefSystemType )
                    // InternalMyDsl.g:582:6: lv_beliefsystemtype_24_0= ruleBeliefSystemType
                    {

                    						newCompositeNode(grammarAccess.getWorldConceptsAccess().getBeliefsystemtypeBeliefSystemTypeParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_beliefsystemtype_24_0=ruleBeliefSystemType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    						}
                    						add(
                    							current,
                    							"beliefsystemtype",
                    							lv_beliefsystemtype_24_0,
                    							"org.xtext.mydsl.MyDsl.BeliefSystemType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:599:4: (otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==23) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalMyDsl.g:600:5: otherlv_25= ',' ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) )
                    	    {
                    	    otherlv_25=(Token)match(input,23,FOLLOW_31); 

                    	    					newLeafNode(otherlv_25, grammarAccess.getWorldConceptsAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMyDsl.g:604:5: ( (lv_beliefsystemtype_26_0= ruleBeliefSystemType ) )
                    	    // InternalMyDsl.g:605:6: (lv_beliefsystemtype_26_0= ruleBeliefSystemType )
                    	    {
                    	    // InternalMyDsl.g:605:6: (lv_beliefsystemtype_26_0= ruleBeliefSystemType )
                    	    // InternalMyDsl.g:606:7: lv_beliefsystemtype_26_0= ruleBeliefSystemType
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorldConceptsAccess().getBeliefsystemtypeBeliefSystemTypeParserRuleCall_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_beliefsystemtype_26_0=ruleBeliefSystemType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"beliefsystemtype",
                    	    								lv_beliefsystemtype_26_0,
                    	    								"org.xtext.mydsl.MyDsl.BeliefSystemType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,20,FOLLOW_32); 

                    				newLeafNode(otherlv_27, grammarAccess.getWorldConceptsAccess().getRightCurlyBracketKeyword_7_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:629:3: (otherlv_28= 'relationshiptype' otherlv_29= '{' ( (lv_relationshiptype_30_0= ruleRelationshipType ) ) (otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) ) )* otherlv_33= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==30) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:630:4: otherlv_28= 'relationshiptype' otherlv_29= '{' ( (lv_relationshiptype_30_0= ruleRelationshipType ) ) (otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) ) )* otherlv_33= '}'
                    {
                    otherlv_28=(Token)match(input,30,FOLLOW_3); 

                    				newLeafNode(otherlv_28, grammarAccess.getWorldConceptsAccess().getRelationshiptypeKeyword_8_0());
                    			
                    otherlv_29=(Token)match(input,12,FOLLOW_33); 

                    				newLeafNode(otherlv_29, grammarAccess.getWorldConceptsAccess().getLeftCurlyBracketKeyword_8_1());
                    			
                    // InternalMyDsl.g:638:4: ( (lv_relationshiptype_30_0= ruleRelationshipType ) )
                    // InternalMyDsl.g:639:5: (lv_relationshiptype_30_0= ruleRelationshipType )
                    {
                    // InternalMyDsl.g:639:5: (lv_relationshiptype_30_0= ruleRelationshipType )
                    // InternalMyDsl.g:640:6: lv_relationshiptype_30_0= ruleRelationshipType
                    {

                    						newCompositeNode(grammarAccess.getWorldConceptsAccess().getRelationshiptypeRelationshipTypeParserRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_relationshiptype_30_0=ruleRelationshipType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    						}
                    						add(
                    							current,
                    							"relationshiptype",
                    							lv_relationshiptype_30_0,
                    							"org.xtext.mydsl.MyDsl.RelationshipType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:657:4: (otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==23) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalMyDsl.g:658:5: otherlv_31= ',' ( (lv_relationshiptype_32_0= ruleRelationshipType ) )
                    	    {
                    	    otherlv_31=(Token)match(input,23,FOLLOW_33); 

                    	    					newLeafNode(otherlv_31, grammarAccess.getWorldConceptsAccess().getCommaKeyword_8_3_0());
                    	    				
                    	    // InternalMyDsl.g:662:5: ( (lv_relationshiptype_32_0= ruleRelationshipType ) )
                    	    // InternalMyDsl.g:663:6: (lv_relationshiptype_32_0= ruleRelationshipType )
                    	    {
                    	    // InternalMyDsl.g:663:6: (lv_relationshiptype_32_0= ruleRelationshipType )
                    	    // InternalMyDsl.g:664:7: lv_relationshiptype_32_0= ruleRelationshipType
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorldConceptsAccess().getRelationshiptypeRelationshipTypeParserRuleCall_8_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_relationshiptype_32_0=ruleRelationshipType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorldConceptsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"relationshiptype",
                    	    								lv_relationshiptype_32_0,
                    	    								"org.xtext.mydsl.MyDsl.RelationshipType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_33, grammarAccess.getWorldConceptsAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_34=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_34, grammarAccess.getWorldConceptsAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorldConcepts"


    // $ANTLR start "entryRuleLocationSheet"
    // InternalMyDsl.g:695:1: entryRuleLocationSheet returns [EObject current=null] : iv_ruleLocationSheet= ruleLocationSheet EOF ;
    public final EObject entryRuleLocationSheet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocationSheet = null;


        try {
            // InternalMyDsl.g:695:54: (iv_ruleLocationSheet= ruleLocationSheet EOF )
            // InternalMyDsl.g:696:2: iv_ruleLocationSheet= ruleLocationSheet EOF
            {
             newCompositeNode(grammarAccess.getLocationSheetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocationSheet=ruleLocationSheet();

            state._fsp--;

             current =iv_ruleLocationSheet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocationSheet"


    // $ANTLR start "ruleLocationSheet"
    // InternalMyDsl.g:702:1: ruleLocationSheet returns [EObject current=null] : ( () otherlv_1= 'LocationSheet' otherlv_2= '{' (otherlv_3= 'location' otherlv_4= '{' ( (lv_location_5_0= ruleLocation ) ) (otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleLocationSheet() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_location_5_0 = null;

        EObject lv_location_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:708:2: ( ( () otherlv_1= 'LocationSheet' otherlv_2= '{' (otherlv_3= 'location' otherlv_4= '{' ( (lv_location_5_0= ruleLocation ) ) (otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:709:2: ( () otherlv_1= 'LocationSheet' otherlv_2= '{' (otherlv_3= 'location' otherlv_4= '{' ( (lv_location_5_0= ruleLocation ) ) (otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:709:2: ( () otherlv_1= 'LocationSheet' otherlv_2= '{' (otherlv_3= 'location' otherlv_4= '{' ( (lv_location_5_0= ruleLocation ) ) (otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:710:3: () otherlv_1= 'LocationSheet' otherlv_2= '{' (otherlv_3= 'location' otherlv_4= '{' ( (lv_location_5_0= ruleLocation ) ) (otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:710:3: ()
            // InternalMyDsl.g:711:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLocationSheetAccess().getLocationSheetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getLocationSheetAccess().getLocationSheetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getLocationSheetAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:725:3: (otherlv_3= 'location' otherlv_4= '{' ( (lv_location_5_0= ruleLocation ) ) (otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) ) )* otherlv_8= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==32) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:726:4: otherlv_3= 'location' otherlv_4= '{' ( (lv_location_5_0= ruleLocation ) ) (otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getLocationSheetAccess().getLocationKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_35); 

                    				newLeafNode(otherlv_4, grammarAccess.getLocationSheetAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:734:4: ( (lv_location_5_0= ruleLocation ) )
                    // InternalMyDsl.g:735:5: (lv_location_5_0= ruleLocation )
                    {
                    // InternalMyDsl.g:735:5: (lv_location_5_0= ruleLocation )
                    // InternalMyDsl.g:736:6: lv_location_5_0= ruleLocation
                    {

                    						newCompositeNode(grammarAccess.getLocationSheetAccess().getLocationLocationParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_location_5_0=ruleLocation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLocationSheetRule());
                    						}
                    						add(
                    							current,
                    							"location",
                    							lv_location_5_0,
                    							"org.xtext.mydsl.MyDsl.Location");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:753:4: (otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==23) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalMyDsl.g:754:5: otherlv_6= ',' ( (lv_location_7_0= ruleLocation ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_35); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getLocationSheetAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:758:5: ( (lv_location_7_0= ruleLocation ) )
                    	    // InternalMyDsl.g:759:6: (lv_location_7_0= ruleLocation )
                    	    {
                    	    // InternalMyDsl.g:759:6: (lv_location_7_0= ruleLocation )
                    	    // InternalMyDsl.g:760:7: lv_location_7_0= ruleLocation
                    	    {

                    	    							newCompositeNode(grammarAccess.getLocationSheetAccess().getLocationLocationParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_location_7_0=ruleLocation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getLocationSheetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"location",
                    	    								lv_location_7_0,
                    	    								"org.xtext.mydsl.MyDsl.Location");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getLocationSheetAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getLocationSheetAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocationSheet"


    // $ANTLR start "entryRulePoliticalEntitySheet"
    // InternalMyDsl.g:791:1: entryRulePoliticalEntitySheet returns [EObject current=null] : iv_rulePoliticalEntitySheet= rulePoliticalEntitySheet EOF ;
    public final EObject entryRulePoliticalEntitySheet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoliticalEntitySheet = null;


        try {
            // InternalMyDsl.g:791:61: (iv_rulePoliticalEntitySheet= rulePoliticalEntitySheet EOF )
            // InternalMyDsl.g:792:2: iv_rulePoliticalEntitySheet= rulePoliticalEntitySheet EOF
            {
             newCompositeNode(grammarAccess.getPoliticalEntitySheetRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoliticalEntitySheet=rulePoliticalEntitySheet();

            state._fsp--;

             current =iv_rulePoliticalEntitySheet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoliticalEntitySheet"


    // $ANTLR start "rulePoliticalEntitySheet"
    // InternalMyDsl.g:798:1: rulePoliticalEntitySheet returns [EObject current=null] : ( () otherlv_1= 'PoliticalEntitySheet' otherlv_2= '{' (otherlv_3= 'politicalentity' otherlv_4= '{' ( (lv_politicalentity_5_0= rulePoliticalEntity ) ) (otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject rulePoliticalEntitySheet() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_politicalentity_5_0 = null;

        EObject lv_politicalentity_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:804:2: ( ( () otherlv_1= 'PoliticalEntitySheet' otherlv_2= '{' (otherlv_3= 'politicalentity' otherlv_4= '{' ( (lv_politicalentity_5_0= rulePoliticalEntity ) ) (otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:805:2: ( () otherlv_1= 'PoliticalEntitySheet' otherlv_2= '{' (otherlv_3= 'politicalentity' otherlv_4= '{' ( (lv_politicalentity_5_0= rulePoliticalEntity ) ) (otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:805:2: ( () otherlv_1= 'PoliticalEntitySheet' otherlv_2= '{' (otherlv_3= 'politicalentity' otherlv_4= '{' ( (lv_politicalentity_5_0= rulePoliticalEntity ) ) (otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:806:3: () otherlv_1= 'PoliticalEntitySheet' otherlv_2= '{' (otherlv_3= 'politicalentity' otherlv_4= '{' ( (lv_politicalentity_5_0= rulePoliticalEntity ) ) (otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:806:3: ()
            // InternalMyDsl.g:807:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPoliticalEntitySheetAccess().getPoliticalEntitySheetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPoliticalEntitySheetAccess().getPoliticalEntitySheetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getPoliticalEntitySheetAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:821:3: (otherlv_3= 'politicalentity' otherlv_4= '{' ( (lv_politicalentity_5_0= rulePoliticalEntity ) ) (otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) ) )* otherlv_8= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==34) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:822:4: otherlv_3= 'politicalentity' otherlv_4= '{' ( (lv_politicalentity_5_0= rulePoliticalEntity ) ) (otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getPoliticalEntitySheetAccess().getPoliticalentityKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_37); 

                    				newLeafNode(otherlv_4, grammarAccess.getPoliticalEntitySheetAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:830:4: ( (lv_politicalentity_5_0= rulePoliticalEntity ) )
                    // InternalMyDsl.g:831:5: (lv_politicalentity_5_0= rulePoliticalEntity )
                    {
                    // InternalMyDsl.g:831:5: (lv_politicalentity_5_0= rulePoliticalEntity )
                    // InternalMyDsl.g:832:6: lv_politicalentity_5_0= rulePoliticalEntity
                    {

                    						newCompositeNode(grammarAccess.getPoliticalEntitySheetAccess().getPoliticalentityPoliticalEntityParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_politicalentity_5_0=rulePoliticalEntity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPoliticalEntitySheetRule());
                    						}
                    						add(
                    							current,
                    							"politicalentity",
                    							lv_politicalentity_5_0,
                    							"org.xtext.mydsl.MyDsl.PoliticalEntity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:849:4: (otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==23) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalMyDsl.g:850:5: otherlv_6= ',' ( (lv_politicalentity_7_0= rulePoliticalEntity ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_37); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getPoliticalEntitySheetAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:854:5: ( (lv_politicalentity_7_0= rulePoliticalEntity ) )
                    	    // InternalMyDsl.g:855:6: (lv_politicalentity_7_0= rulePoliticalEntity )
                    	    {
                    	    // InternalMyDsl.g:855:6: (lv_politicalentity_7_0= rulePoliticalEntity )
                    	    // InternalMyDsl.g:856:7: lv_politicalentity_7_0= rulePoliticalEntity
                    	    {

                    	    							newCompositeNode(grammarAccess.getPoliticalEntitySheetAccess().getPoliticalentityPoliticalEntityParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_politicalentity_7_0=rulePoliticalEntity();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPoliticalEntitySheetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"politicalentity",
                    	    								lv_politicalentity_7_0,
                    	    								"org.xtext.mydsl.MyDsl.PoliticalEntity");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getPoliticalEntitySheetAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getPoliticalEntitySheetAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoliticalEntitySheet"


    // $ANTLR start "entryRuleBeliefSystemSheet"
    // InternalMyDsl.g:887:1: entryRuleBeliefSystemSheet returns [EObject current=null] : iv_ruleBeliefSystemSheet= ruleBeliefSystemSheet EOF ;
    public final EObject entryRuleBeliefSystemSheet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefSystemSheet = null;


        try {
            // InternalMyDsl.g:887:58: (iv_ruleBeliefSystemSheet= ruleBeliefSystemSheet EOF )
            // InternalMyDsl.g:888:2: iv_ruleBeliefSystemSheet= ruleBeliefSystemSheet EOF
            {
             newCompositeNode(grammarAccess.getBeliefSystemSheetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeliefSystemSheet=ruleBeliefSystemSheet();

            state._fsp--;

             current =iv_ruleBeliefSystemSheet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBeliefSystemSheet"


    // $ANTLR start "ruleBeliefSystemSheet"
    // InternalMyDsl.g:894:1: ruleBeliefSystemSheet returns [EObject current=null] : ( () otherlv_1= 'BeliefSystemSheet' otherlv_2= '{' (otherlv_3= 'beliefsystem' otherlv_4= '{' ( (lv_beliefsystem_5_0= ruleBeliefSystem ) ) (otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleBeliefSystemSheet() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_beliefsystem_5_0 = null;

        EObject lv_beliefsystem_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:900:2: ( ( () otherlv_1= 'BeliefSystemSheet' otherlv_2= '{' (otherlv_3= 'beliefsystem' otherlv_4= '{' ( (lv_beliefsystem_5_0= ruleBeliefSystem ) ) (otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:901:2: ( () otherlv_1= 'BeliefSystemSheet' otherlv_2= '{' (otherlv_3= 'beliefsystem' otherlv_4= '{' ( (lv_beliefsystem_5_0= ruleBeliefSystem ) ) (otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:901:2: ( () otherlv_1= 'BeliefSystemSheet' otherlv_2= '{' (otherlv_3= 'beliefsystem' otherlv_4= '{' ( (lv_beliefsystem_5_0= ruleBeliefSystem ) ) (otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:902:3: () otherlv_1= 'BeliefSystemSheet' otherlv_2= '{' (otherlv_3= 'beliefsystem' otherlv_4= '{' ( (lv_beliefsystem_5_0= ruleBeliefSystem ) ) (otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:902:3: ()
            // InternalMyDsl.g:903:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBeliefSystemSheetAccess().getBeliefSystemSheetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getBeliefSystemSheetAccess().getBeliefSystemSheetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getBeliefSystemSheetAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:917:3: (otherlv_3= 'beliefsystem' otherlv_4= '{' ( (lv_beliefsystem_5_0= ruleBeliefSystem ) ) (otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) ) )* otherlv_8= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==36) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMyDsl.g:918:4: otherlv_3= 'beliefsystem' otherlv_4= '{' ( (lv_beliefsystem_5_0= ruleBeliefSystem ) ) (otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getBeliefSystemSheetAccess().getBeliefsystemKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_39); 

                    				newLeafNode(otherlv_4, grammarAccess.getBeliefSystemSheetAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:926:4: ( (lv_beliefsystem_5_0= ruleBeliefSystem ) )
                    // InternalMyDsl.g:927:5: (lv_beliefsystem_5_0= ruleBeliefSystem )
                    {
                    // InternalMyDsl.g:927:5: (lv_beliefsystem_5_0= ruleBeliefSystem )
                    // InternalMyDsl.g:928:6: lv_beliefsystem_5_0= ruleBeliefSystem
                    {

                    						newCompositeNode(grammarAccess.getBeliefSystemSheetAccess().getBeliefsystemBeliefSystemParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_beliefsystem_5_0=ruleBeliefSystem();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBeliefSystemSheetRule());
                    						}
                    						add(
                    							current,
                    							"beliefsystem",
                    							lv_beliefsystem_5_0,
                    							"org.xtext.mydsl.MyDsl.BeliefSystem");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:945:4: (otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==23) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalMyDsl.g:946:5: otherlv_6= ',' ( (lv_beliefsystem_7_0= ruleBeliefSystem ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_39); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getBeliefSystemSheetAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:950:5: ( (lv_beliefsystem_7_0= ruleBeliefSystem ) )
                    	    // InternalMyDsl.g:951:6: (lv_beliefsystem_7_0= ruleBeliefSystem )
                    	    {
                    	    // InternalMyDsl.g:951:6: (lv_beliefsystem_7_0= ruleBeliefSystem )
                    	    // InternalMyDsl.g:952:7: lv_beliefsystem_7_0= ruleBeliefSystem
                    	    {

                    	    							newCompositeNode(grammarAccess.getBeliefSystemSheetAccess().getBeliefsystemBeliefSystemParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_beliefsystem_7_0=ruleBeliefSystem();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getBeliefSystemSheetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"beliefsystem",
                    	    								lv_beliefsystem_7_0,
                    	    								"org.xtext.mydsl.MyDsl.BeliefSystem");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getBeliefSystemSheetAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getBeliefSystemSheetAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBeliefSystemSheet"


    // $ANTLR start "entryRuleEventSheet"
    // InternalMyDsl.g:983:1: entryRuleEventSheet returns [EObject current=null] : iv_ruleEventSheet= ruleEventSheet EOF ;
    public final EObject entryRuleEventSheet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventSheet = null;


        try {
            // InternalMyDsl.g:983:51: (iv_ruleEventSheet= ruleEventSheet EOF )
            // InternalMyDsl.g:984:2: iv_ruleEventSheet= ruleEventSheet EOF
            {
             newCompositeNode(grammarAccess.getEventSheetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventSheet=ruleEventSheet();

            state._fsp--;

             current =iv_ruleEventSheet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventSheet"


    // $ANTLR start "ruleEventSheet"
    // InternalMyDsl.g:990:1: ruleEventSheet returns [EObject current=null] : ( () otherlv_1= 'EventSheet' otherlv_2= '{' (otherlv_3= 'event' otherlv_4= '{' ( (lv_event_5_0= ruleEvent ) ) (otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleEventSheet() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_event_5_0 = null;

        EObject lv_event_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:996:2: ( ( () otherlv_1= 'EventSheet' otherlv_2= '{' (otherlv_3= 'event' otherlv_4= '{' ( (lv_event_5_0= ruleEvent ) ) (otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:997:2: ( () otherlv_1= 'EventSheet' otherlv_2= '{' (otherlv_3= 'event' otherlv_4= '{' ( (lv_event_5_0= ruleEvent ) ) (otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:997:2: ( () otherlv_1= 'EventSheet' otherlv_2= '{' (otherlv_3= 'event' otherlv_4= '{' ( (lv_event_5_0= ruleEvent ) ) (otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:998:3: () otherlv_1= 'EventSheet' otherlv_2= '{' (otherlv_3= 'event' otherlv_4= '{' ( (lv_event_5_0= ruleEvent ) ) (otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:998:3: ()
            // InternalMyDsl.g:999:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEventSheetAccess().getEventSheetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getEventSheetAccess().getEventSheetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getEventSheetAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1013:3: (otherlv_3= 'event' otherlv_4= '{' ( (lv_event_5_0= ruleEvent ) ) (otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) ) )* otherlv_8= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:1014:4: otherlv_3= 'event' otherlv_4= '{' ( (lv_event_5_0= ruleEvent ) ) (otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,38,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getEventSheetAccess().getEventKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_41); 

                    				newLeafNode(otherlv_4, grammarAccess.getEventSheetAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:1022:4: ( (lv_event_5_0= ruleEvent ) )
                    // InternalMyDsl.g:1023:5: (lv_event_5_0= ruleEvent )
                    {
                    // InternalMyDsl.g:1023:5: (lv_event_5_0= ruleEvent )
                    // InternalMyDsl.g:1024:6: lv_event_5_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getEventSheetAccess().getEventEventParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_event_5_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventSheetRule());
                    						}
                    						add(
                    							current,
                    							"event",
                    							lv_event_5_0,
                    							"org.xtext.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1041:4: (otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==23) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalMyDsl.g:1042:5: otherlv_6= ',' ( (lv_event_7_0= ruleEvent ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_41); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getEventSheetAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:1046:5: ( (lv_event_7_0= ruleEvent ) )
                    	    // InternalMyDsl.g:1047:6: (lv_event_7_0= ruleEvent )
                    	    {
                    	    // InternalMyDsl.g:1047:6: (lv_event_7_0= ruleEvent )
                    	    // InternalMyDsl.g:1048:7: lv_event_7_0= ruleEvent
                    	    {

                    	    							newCompositeNode(grammarAccess.getEventSheetAccess().getEventEventParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_event_7_0=ruleEvent();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEventSheetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"event",
                    	    								lv_event_7_0,
                    	    								"org.xtext.mydsl.MyDsl.Event");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getEventSheetAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getEventSheetAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEventSheet"


    // $ANTLR start "entryRulePresenceSheet"
    // InternalMyDsl.g:1079:1: entryRulePresenceSheet returns [EObject current=null] : iv_rulePresenceSheet= rulePresenceSheet EOF ;
    public final EObject entryRulePresenceSheet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePresenceSheet = null;


        try {
            // InternalMyDsl.g:1079:54: (iv_rulePresenceSheet= rulePresenceSheet EOF )
            // InternalMyDsl.g:1080:2: iv_rulePresenceSheet= rulePresenceSheet EOF
            {
             newCompositeNode(grammarAccess.getPresenceSheetRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePresenceSheet=rulePresenceSheet();

            state._fsp--;

             current =iv_rulePresenceSheet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePresenceSheet"


    // $ANTLR start "rulePresenceSheet"
    // InternalMyDsl.g:1086:1: rulePresenceSheet returns [EObject current=null] : ( () otherlv_1= 'PresenceSheet' otherlv_2= '{' (otherlv_3= 'presence' otherlv_4= '{' ( (lv_presence_5_0= rulePresence ) ) (otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject rulePresenceSheet() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_presence_5_0 = null;

        EObject lv_presence_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1092:2: ( ( () otherlv_1= 'PresenceSheet' otherlv_2= '{' (otherlv_3= 'presence' otherlv_4= '{' ( (lv_presence_5_0= rulePresence ) ) (otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:1093:2: ( () otherlv_1= 'PresenceSheet' otherlv_2= '{' (otherlv_3= 'presence' otherlv_4= '{' ( (lv_presence_5_0= rulePresence ) ) (otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:1093:2: ( () otherlv_1= 'PresenceSheet' otherlv_2= '{' (otherlv_3= 'presence' otherlv_4= '{' ( (lv_presence_5_0= rulePresence ) ) (otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:1094:3: () otherlv_1= 'PresenceSheet' otherlv_2= '{' (otherlv_3= 'presence' otherlv_4= '{' ( (lv_presence_5_0= rulePresence ) ) (otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:1094:3: ()
            // InternalMyDsl.g:1095:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPresenceSheetAccess().getPresenceSheetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPresenceSheetAccess().getPresenceSheetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getPresenceSheetAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1109:3: (otherlv_3= 'presence' otherlv_4= '{' ( (lv_presence_5_0= rulePresence ) ) (otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) ) )* otherlv_8= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:1110:4: otherlv_3= 'presence' otherlv_4= '{' ( (lv_presence_5_0= rulePresence ) ) (otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,40,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getPresenceSheetAccess().getPresenceKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_43); 

                    				newLeafNode(otherlv_4, grammarAccess.getPresenceSheetAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:1118:4: ( (lv_presence_5_0= rulePresence ) )
                    // InternalMyDsl.g:1119:5: (lv_presence_5_0= rulePresence )
                    {
                    // InternalMyDsl.g:1119:5: (lv_presence_5_0= rulePresence )
                    // InternalMyDsl.g:1120:6: lv_presence_5_0= rulePresence
                    {

                    						newCompositeNode(grammarAccess.getPresenceSheetAccess().getPresencePresenceParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_presence_5_0=rulePresence();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPresenceSheetRule());
                    						}
                    						add(
                    							current,
                    							"presence",
                    							lv_presence_5_0,
                    							"org.xtext.mydsl.MyDsl.Presence");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1137:4: (otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==23) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalMyDsl.g:1138:5: otherlv_6= ',' ( (lv_presence_7_0= rulePresence ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_43); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getPresenceSheetAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:1142:5: ( (lv_presence_7_0= rulePresence ) )
                    	    // InternalMyDsl.g:1143:6: (lv_presence_7_0= rulePresence )
                    	    {
                    	    // InternalMyDsl.g:1143:6: (lv_presence_7_0= rulePresence )
                    	    // InternalMyDsl.g:1144:7: lv_presence_7_0= rulePresence
                    	    {

                    	    							newCompositeNode(grammarAccess.getPresenceSheetAccess().getPresencePresenceParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_presence_7_0=rulePresence();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPresenceSheetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"presence",
                    	    								lv_presence_7_0,
                    	    								"org.xtext.mydsl.MyDsl.Presence");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getPresenceSheetAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getPresenceSheetAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePresenceSheet"


    // $ANTLR start "entryRuleCharacter"
    // InternalMyDsl.g:1175:1: entryRuleCharacter returns [EObject current=null] : iv_ruleCharacter= ruleCharacter EOF ;
    public final EObject entryRuleCharacter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacter = null;


        try {
            // InternalMyDsl.g:1175:50: (iv_ruleCharacter= ruleCharacter EOF )
            // InternalMyDsl.g:1176:2: iv_ruleCharacter= ruleCharacter EOF
            {
             newCompositeNode(grammarAccess.getCharacterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCharacter=ruleCharacter();

            state._fsp--;

             current =iv_ruleCharacter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCharacter"


    // $ANTLR start "ruleCharacter"
    // InternalMyDsl.g:1182:1: ruleCharacter returns [EObject current=null] : ( () otherlv_1= 'Character' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'first_name' ( (lv_first_name_6_0= ruleEString ) ) )? (otherlv_7= 'last_name' ( (lv_last_name_8_0= ruleEString ) ) )? (otherlv_9= 'occupation' ( (lv_occupation_10_0= ruleEString ) ) )? (otherlv_11= 'children' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'believes' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' )? (otherlv_23= 'supports' ( ( ruleEString ) ) )? (otherlv_25= 'animalspeciestype' ( ( ruleEString ) ) )? (otherlv_27= 'birth' ( (lv_birth_28_0= ruleTimestamp ) ) )? (otherlv_29= 'death' ( (lv_death_30_0= ruleTimestamp ) ) )? (otherlv_31= 'relationship' otherlv_32= '{' ( (lv_relationship_33_0= ruleRelationship ) ) (otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) ) )* otherlv_36= '}' )? otherlv_37= '}' ) ;
    public final EObject ruleCharacter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        AntlrDatatypeRuleToken lv_description_4_0 = null;

        AntlrDatatypeRuleToken lv_first_name_6_0 = null;

        AntlrDatatypeRuleToken lv_last_name_8_0 = null;

        AntlrDatatypeRuleToken lv_occupation_10_0 = null;

        EObject lv_birth_28_0 = null;

        EObject lv_death_30_0 = null;

        EObject lv_relationship_33_0 = null;

        EObject lv_relationship_35_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1188:2: ( ( () otherlv_1= 'Character' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'first_name' ( (lv_first_name_6_0= ruleEString ) ) )? (otherlv_7= 'last_name' ( (lv_last_name_8_0= ruleEString ) ) )? (otherlv_9= 'occupation' ( (lv_occupation_10_0= ruleEString ) ) )? (otherlv_11= 'children' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'believes' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' )? (otherlv_23= 'supports' ( ( ruleEString ) ) )? (otherlv_25= 'animalspeciestype' ( ( ruleEString ) ) )? (otherlv_27= 'birth' ( (lv_birth_28_0= ruleTimestamp ) ) )? (otherlv_29= 'death' ( (lv_death_30_0= ruleTimestamp ) ) )? (otherlv_31= 'relationship' otherlv_32= '{' ( (lv_relationship_33_0= ruleRelationship ) ) (otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) ) )* otherlv_36= '}' )? otherlv_37= '}' ) )
            // InternalMyDsl.g:1189:2: ( () otherlv_1= 'Character' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'first_name' ( (lv_first_name_6_0= ruleEString ) ) )? (otherlv_7= 'last_name' ( (lv_last_name_8_0= ruleEString ) ) )? (otherlv_9= 'occupation' ( (lv_occupation_10_0= ruleEString ) ) )? (otherlv_11= 'children' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'believes' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' )? (otherlv_23= 'supports' ( ( ruleEString ) ) )? (otherlv_25= 'animalspeciestype' ( ( ruleEString ) ) )? (otherlv_27= 'birth' ( (lv_birth_28_0= ruleTimestamp ) ) )? (otherlv_29= 'death' ( (lv_death_30_0= ruleTimestamp ) ) )? (otherlv_31= 'relationship' otherlv_32= '{' ( (lv_relationship_33_0= ruleRelationship ) ) (otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) ) )* otherlv_36= '}' )? otherlv_37= '}' )
            {
            // InternalMyDsl.g:1189:2: ( () otherlv_1= 'Character' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'first_name' ( (lv_first_name_6_0= ruleEString ) ) )? (otherlv_7= 'last_name' ( (lv_last_name_8_0= ruleEString ) ) )? (otherlv_9= 'occupation' ( (lv_occupation_10_0= ruleEString ) ) )? (otherlv_11= 'children' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'believes' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' )? (otherlv_23= 'supports' ( ( ruleEString ) ) )? (otherlv_25= 'animalspeciestype' ( ( ruleEString ) ) )? (otherlv_27= 'birth' ( (lv_birth_28_0= ruleTimestamp ) ) )? (otherlv_29= 'death' ( (lv_death_30_0= ruleTimestamp ) ) )? (otherlv_31= 'relationship' otherlv_32= '{' ( (lv_relationship_33_0= ruleRelationship ) ) (otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) ) )* otherlv_36= '}' )? otherlv_37= '}' )
            // InternalMyDsl.g:1190:3: () otherlv_1= 'Character' otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'first_name' ( (lv_first_name_6_0= ruleEString ) ) )? (otherlv_7= 'last_name' ( (lv_last_name_8_0= ruleEString ) ) )? (otherlv_9= 'occupation' ( (lv_occupation_10_0= ruleEString ) ) )? (otherlv_11= 'children' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'believes' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' )? (otherlv_23= 'supports' ( ( ruleEString ) ) )? (otherlv_25= 'animalspeciestype' ( ( ruleEString ) ) )? (otherlv_27= 'birth' ( (lv_birth_28_0= ruleTimestamp ) ) )? (otherlv_29= 'death' ( (lv_death_30_0= ruleTimestamp ) ) )? (otherlv_31= 'relationship' otherlv_32= '{' ( (lv_relationship_33_0= ruleRelationship ) ) (otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) ) )* otherlv_36= '}' )? otherlv_37= '}'
            {
            // InternalMyDsl.g:1190:3: ()
            // InternalMyDsl.g:1191:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCharacterAccess().getCharacterAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCharacterAccess().getCharacterKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getCharacterAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1205:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==42) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:1206:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getCharacterAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1210:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1211:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1211:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1212:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCharacterAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1230:3: (otherlv_5= 'first_name' ( (lv_first_name_6_0= ruleEString ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==43) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:1231:4: otherlv_5= 'first_name' ( (lv_first_name_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,43,FOLLOW_23); 

                    				newLeafNode(otherlv_5, grammarAccess.getCharacterAccess().getFirst_nameKeyword_4_0());
                    			
                    // InternalMyDsl.g:1235:4: ( (lv_first_name_6_0= ruleEString ) )
                    // InternalMyDsl.g:1236:5: (lv_first_name_6_0= ruleEString )
                    {
                    // InternalMyDsl.g:1236:5: (lv_first_name_6_0= ruleEString )
                    // InternalMyDsl.g:1237:6: lv_first_name_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCharacterAccess().getFirst_nameEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_first_name_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRule());
                    						}
                    						set(
                    							current,
                    							"first_name",
                    							lv_first_name_6_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1255:3: (otherlv_7= 'last_name' ( (lv_last_name_8_0= ruleEString ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==44) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:1256:4: otherlv_7= 'last_name' ( (lv_last_name_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,44,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getCharacterAccess().getLast_nameKeyword_5_0());
                    			
                    // InternalMyDsl.g:1260:4: ( (lv_last_name_8_0= ruleEString ) )
                    // InternalMyDsl.g:1261:5: (lv_last_name_8_0= ruleEString )
                    {
                    // InternalMyDsl.g:1261:5: (lv_last_name_8_0= ruleEString )
                    // InternalMyDsl.g:1262:6: lv_last_name_8_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCharacterAccess().getLast_nameEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_47);
                    lv_last_name_8_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRule());
                    						}
                    						set(
                    							current,
                    							"last_name",
                    							lv_last_name_8_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1280:3: (otherlv_9= 'occupation' ( (lv_occupation_10_0= ruleEString ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==45) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMyDsl.g:1281:4: otherlv_9= 'occupation' ( (lv_occupation_10_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,45,FOLLOW_23); 

                    				newLeafNode(otherlv_9, grammarAccess.getCharacterAccess().getOccupationKeyword_6_0());
                    			
                    // InternalMyDsl.g:1285:4: ( (lv_occupation_10_0= ruleEString ) )
                    // InternalMyDsl.g:1286:5: (lv_occupation_10_0= ruleEString )
                    {
                    // InternalMyDsl.g:1286:5: (lv_occupation_10_0= ruleEString )
                    // InternalMyDsl.g:1287:6: lv_occupation_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCharacterAccess().getOccupationEStringParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_48);
                    lv_occupation_10_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRule());
                    						}
                    						set(
                    							current,
                    							"occupation",
                    							lv_occupation_10_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1305:3: (otherlv_11= 'children' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==46) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:1306:4: otherlv_11= 'children' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')'
                    {
                    otherlv_11=(Token)match(input,46,FOLLOW_49); 

                    				newLeafNode(otherlv_11, grammarAccess.getCharacterAccess().getChildrenKeyword_7_0());
                    			
                    otherlv_12=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_12, grammarAccess.getCharacterAccess().getLeftParenthesisKeyword_7_1());
                    			
                    // InternalMyDsl.g:1314:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1315:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1315:5: ( ruleEString )
                    // InternalMyDsl.g:1316:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCharacterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCharacterAccess().getChildrenCharacterCrossReference_7_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1330:4: (otherlv_14= ',' ( ( ruleEString ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==23) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalMyDsl.g:1331:5: otherlv_14= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_14=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getCharacterAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMyDsl.g:1335:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1336:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1336:6: ( ruleEString )
                    	    // InternalMyDsl.g:1337:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getCharacterRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getCharacterAccess().getChildrenCharacterCrossReference_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,48,FOLLOW_51); 

                    				newLeafNode(otherlv_16, grammarAccess.getCharacterAccess().getRightParenthesisKeyword_7_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:1357:3: (otherlv_17= 'believes' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==49) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMyDsl.g:1358:4: otherlv_17= 'believes' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')'
                    {
                    otherlv_17=(Token)match(input,49,FOLLOW_49); 

                    				newLeafNode(otherlv_17, grammarAccess.getCharacterAccess().getBelievesKeyword_8_0());
                    			
                    otherlv_18=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_18, grammarAccess.getCharacterAccess().getLeftParenthesisKeyword_8_1());
                    			
                    // InternalMyDsl.g:1366:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1367:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1367:5: ( ruleEString )
                    // InternalMyDsl.g:1368:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCharacterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCharacterAccess().getBelievesBeliefSystemCrossReference_8_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1382:4: (otherlv_20= ',' ( ( ruleEString ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==23) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalMyDsl.g:1383:5: otherlv_20= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_20=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getCharacterAccess().getCommaKeyword_8_3_0());
                    	    				
                    	    // InternalMyDsl.g:1387:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:1388:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:1388:6: ( ruleEString )
                    	    // InternalMyDsl.g:1389:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getCharacterRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getCharacterAccess().getBelievesBeliefSystemCrossReference_8_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,48,FOLLOW_52); 

                    				newLeafNode(otherlv_22, grammarAccess.getCharacterAccess().getRightParenthesisKeyword_8_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:1409:3: (otherlv_23= 'supports' ( ( ruleEString ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==50) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:1410:4: otherlv_23= 'supports' ( ( ruleEString ) )
                    {
                    otherlv_23=(Token)match(input,50,FOLLOW_23); 

                    				newLeafNode(otherlv_23, grammarAccess.getCharacterAccess().getSupportsKeyword_9_0());
                    			
                    // InternalMyDsl.g:1414:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1415:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1415:5: ( ruleEString )
                    // InternalMyDsl.g:1416:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCharacterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCharacterAccess().getSupportsPoliticalEntityCrossReference_9_1_0());
                    					
                    pushFollow(FOLLOW_53);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1431:3: (otherlv_25= 'animalspeciestype' ( ( ruleEString ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==26) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMyDsl.g:1432:4: otherlv_25= 'animalspeciestype' ( ( ruleEString ) )
                    {
                    otherlv_25=(Token)match(input,26,FOLLOW_23); 

                    				newLeafNode(otherlv_25, grammarAccess.getCharacterAccess().getAnimalspeciestypeKeyword_10_0());
                    			
                    // InternalMyDsl.g:1436:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1437:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1437:5: ( ruleEString )
                    // InternalMyDsl.g:1438:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCharacterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCharacterAccess().getAnimalspeciestypeAnimalSpeciesTypeCrossReference_10_1_0());
                    					
                    pushFollow(FOLLOW_54);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1453:3: (otherlv_27= 'birth' ( (lv_birth_28_0= ruleTimestamp ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==51) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMyDsl.g:1454:4: otherlv_27= 'birth' ( (lv_birth_28_0= ruleTimestamp ) )
                    {
                    otherlv_27=(Token)match(input,51,FOLLOW_55); 

                    				newLeafNode(otherlv_27, grammarAccess.getCharacterAccess().getBirthKeyword_11_0());
                    			
                    // InternalMyDsl.g:1458:4: ( (lv_birth_28_0= ruleTimestamp ) )
                    // InternalMyDsl.g:1459:5: (lv_birth_28_0= ruleTimestamp )
                    {
                    // InternalMyDsl.g:1459:5: (lv_birth_28_0= ruleTimestamp )
                    // InternalMyDsl.g:1460:6: lv_birth_28_0= ruleTimestamp
                    {

                    						newCompositeNode(grammarAccess.getCharacterAccess().getBirthTimestampParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_56);
                    lv_birth_28_0=ruleTimestamp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRule());
                    						}
                    						set(
                    							current,
                    							"birth",
                    							lv_birth_28_0,
                    							"org.xtext.mydsl.MyDsl.Timestamp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1478:3: (otherlv_29= 'death' ( (lv_death_30_0= ruleTimestamp ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==52) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMyDsl.g:1479:4: otherlv_29= 'death' ( (lv_death_30_0= ruleTimestamp ) )
                    {
                    otherlv_29=(Token)match(input,52,FOLLOW_55); 

                    				newLeafNode(otherlv_29, grammarAccess.getCharacterAccess().getDeathKeyword_12_0());
                    			
                    // InternalMyDsl.g:1483:4: ( (lv_death_30_0= ruleTimestamp ) )
                    // InternalMyDsl.g:1484:5: (lv_death_30_0= ruleTimestamp )
                    {
                    // InternalMyDsl.g:1484:5: (lv_death_30_0= ruleTimestamp )
                    // InternalMyDsl.g:1485:6: lv_death_30_0= ruleTimestamp
                    {

                    						newCompositeNode(grammarAccess.getCharacterAccess().getDeathTimestampParserRuleCall_12_1_0());
                    					
                    pushFollow(FOLLOW_57);
                    lv_death_30_0=ruleTimestamp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRule());
                    						}
                    						set(
                    							current,
                    							"death",
                    							lv_death_30_0,
                    							"org.xtext.mydsl.MyDsl.Timestamp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1503:3: (otherlv_31= 'relationship' otherlv_32= '{' ( (lv_relationship_33_0= ruleRelationship ) ) (otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) ) )* otherlv_36= '}' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==53) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMyDsl.g:1504:4: otherlv_31= 'relationship' otherlv_32= '{' ( (lv_relationship_33_0= ruleRelationship ) ) (otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) ) )* otherlv_36= '}'
                    {
                    otherlv_31=(Token)match(input,53,FOLLOW_3); 

                    				newLeafNode(otherlv_31, grammarAccess.getCharacterAccess().getRelationshipKeyword_13_0());
                    			
                    otherlv_32=(Token)match(input,12,FOLLOW_58); 

                    				newLeafNode(otherlv_32, grammarAccess.getCharacterAccess().getLeftCurlyBracketKeyword_13_1());
                    			
                    // InternalMyDsl.g:1512:4: ( (lv_relationship_33_0= ruleRelationship ) )
                    // InternalMyDsl.g:1513:5: (lv_relationship_33_0= ruleRelationship )
                    {
                    // InternalMyDsl.g:1513:5: (lv_relationship_33_0= ruleRelationship )
                    // InternalMyDsl.g:1514:6: lv_relationship_33_0= ruleRelationship
                    {

                    						newCompositeNode(grammarAccess.getCharacterAccess().getRelationshipRelationshipParserRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_relationship_33_0=ruleRelationship();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRule());
                    						}
                    						add(
                    							current,
                    							"relationship",
                    							lv_relationship_33_0,
                    							"org.xtext.mydsl.MyDsl.Relationship");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1531:4: (otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==23) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalMyDsl.g:1532:5: otherlv_34= ',' ( (lv_relationship_35_0= ruleRelationship ) )
                    	    {
                    	    otherlv_34=(Token)match(input,23,FOLLOW_58); 

                    	    					newLeafNode(otherlv_34, grammarAccess.getCharacterAccess().getCommaKeyword_13_3_0());
                    	    				
                    	    // InternalMyDsl.g:1536:5: ( (lv_relationship_35_0= ruleRelationship ) )
                    	    // InternalMyDsl.g:1537:6: (lv_relationship_35_0= ruleRelationship )
                    	    {
                    	    // InternalMyDsl.g:1537:6: (lv_relationship_35_0= ruleRelationship )
                    	    // InternalMyDsl.g:1538:7: lv_relationship_35_0= ruleRelationship
                    	    {

                    	    							newCompositeNode(grammarAccess.getCharacterAccess().getRelationshipRelationshipParserRuleCall_13_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_relationship_35_0=ruleRelationship();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCharacterRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"relationship",
                    	    								lv_relationship_35_0,
                    	    								"org.xtext.mydsl.MyDsl.Relationship");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,20,FOLLOW_18); 

                    				newLeafNode(otherlv_36, grammarAccess.getCharacterAccess().getRightCurlyBracketKeyword_13_4());
                    			

                    }
                    break;

            }

            otherlv_37=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_37, grammarAccess.getCharacterAccess().getRightCurlyBracketKeyword_14());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCharacter"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:1569:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMyDsl.g:1569:47: (iv_ruleEString= ruleEString EOF )
            // InternalMyDsl.g:1570:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:1576:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1582:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMyDsl.g:1583:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMyDsl.g:1583:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_ID) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalMyDsl.g:1584:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1592:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleTimestamp"
    // InternalMyDsl.g:1603:1: entryRuleTimestamp returns [EObject current=null] : iv_ruleTimestamp= ruleTimestamp EOF ;
    public final EObject entryRuleTimestamp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimestamp = null;


        try {
            // InternalMyDsl.g:1603:50: (iv_ruleTimestamp= ruleTimestamp EOF )
            // InternalMyDsl.g:1604:2: iv_ruleTimestamp= ruleTimestamp EOF
            {
             newCompositeNode(grammarAccess.getTimestampRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimestamp=ruleTimestamp();

            state._fsp--;

             current =iv_ruleTimestamp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimestamp"


    // $ANTLR start "ruleTimestamp"
    // InternalMyDsl.g:1610:1: ruleTimestamp returns [EObject current=null] : ( () otherlv_1= 'Timestamp' otherlv_2= '{' (otherlv_3= 'year' ( (lv_year_4_0= ruleEIntegerObject ) ) )? (otherlv_5= 'month' ( (lv_month_6_0= ruleEIntegerObject ) ) )? (otherlv_7= 'day' ( (lv_day_8_0= ruleEIntegerObject ) ) )? (otherlv_9= 'hour' ( (lv_hour_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'minute' ( (lv_minute_12_0= ruleEIntegerObject ) ) )? (otherlv_13= 'second' ( (lv_second_14_0= ruleEIntegerObject ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleTimestamp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_year_4_0 = null;

        AntlrDatatypeRuleToken lv_month_6_0 = null;

        AntlrDatatypeRuleToken lv_day_8_0 = null;

        AntlrDatatypeRuleToken lv_hour_10_0 = null;

        AntlrDatatypeRuleToken lv_minute_12_0 = null;

        AntlrDatatypeRuleToken lv_second_14_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1616:2: ( ( () otherlv_1= 'Timestamp' otherlv_2= '{' (otherlv_3= 'year' ( (lv_year_4_0= ruleEIntegerObject ) ) )? (otherlv_5= 'month' ( (lv_month_6_0= ruleEIntegerObject ) ) )? (otherlv_7= 'day' ( (lv_day_8_0= ruleEIntegerObject ) ) )? (otherlv_9= 'hour' ( (lv_hour_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'minute' ( (lv_minute_12_0= ruleEIntegerObject ) ) )? (otherlv_13= 'second' ( (lv_second_14_0= ruleEIntegerObject ) ) )? otherlv_15= '}' ) )
            // InternalMyDsl.g:1617:2: ( () otherlv_1= 'Timestamp' otherlv_2= '{' (otherlv_3= 'year' ( (lv_year_4_0= ruleEIntegerObject ) ) )? (otherlv_5= 'month' ( (lv_month_6_0= ruleEIntegerObject ) ) )? (otherlv_7= 'day' ( (lv_day_8_0= ruleEIntegerObject ) ) )? (otherlv_9= 'hour' ( (lv_hour_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'minute' ( (lv_minute_12_0= ruleEIntegerObject ) ) )? (otherlv_13= 'second' ( (lv_second_14_0= ruleEIntegerObject ) ) )? otherlv_15= '}' )
            {
            // InternalMyDsl.g:1617:2: ( () otherlv_1= 'Timestamp' otherlv_2= '{' (otherlv_3= 'year' ( (lv_year_4_0= ruleEIntegerObject ) ) )? (otherlv_5= 'month' ( (lv_month_6_0= ruleEIntegerObject ) ) )? (otherlv_7= 'day' ( (lv_day_8_0= ruleEIntegerObject ) ) )? (otherlv_9= 'hour' ( (lv_hour_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'minute' ( (lv_minute_12_0= ruleEIntegerObject ) ) )? (otherlv_13= 'second' ( (lv_second_14_0= ruleEIntegerObject ) ) )? otherlv_15= '}' )
            // InternalMyDsl.g:1618:3: () otherlv_1= 'Timestamp' otherlv_2= '{' (otherlv_3= 'year' ( (lv_year_4_0= ruleEIntegerObject ) ) )? (otherlv_5= 'month' ( (lv_month_6_0= ruleEIntegerObject ) ) )? (otherlv_7= 'day' ( (lv_day_8_0= ruleEIntegerObject ) ) )? (otherlv_9= 'hour' ( (lv_hour_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'minute' ( (lv_minute_12_0= ruleEIntegerObject ) ) )? (otherlv_13= 'second' ( (lv_second_14_0= ruleEIntegerObject ) ) )? otherlv_15= '}'
            {
            // InternalMyDsl.g:1618:3: ()
            // InternalMyDsl.g:1619:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimestampAccess().getTimestampAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,54,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTimestampAccess().getTimestampKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_59); 

            			newLeafNode(otherlv_2, grammarAccess.getTimestampAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1633:3: (otherlv_3= 'year' ( (lv_year_4_0= ruleEIntegerObject ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==55) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMyDsl.g:1634:4: otherlv_3= 'year' ( (lv_year_4_0= ruleEIntegerObject ) )
                    {
                    otherlv_3=(Token)match(input,55,FOLLOW_60); 

                    				newLeafNode(otherlv_3, grammarAccess.getTimestampAccess().getYearKeyword_3_0());
                    			
                    // InternalMyDsl.g:1638:4: ( (lv_year_4_0= ruleEIntegerObject ) )
                    // InternalMyDsl.g:1639:5: (lv_year_4_0= ruleEIntegerObject )
                    {
                    // InternalMyDsl.g:1639:5: (lv_year_4_0= ruleEIntegerObject )
                    // InternalMyDsl.g:1640:6: lv_year_4_0= ruleEIntegerObject
                    {

                    						newCompositeNode(grammarAccess.getTimestampAccess().getYearEIntegerObjectParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_61);
                    lv_year_4_0=ruleEIntegerObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimestampRule());
                    						}
                    						set(
                    							current,
                    							"year",
                    							lv_year_4_0,
                    							"org.xtext.mydsl.MyDsl.EIntegerObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1658:3: (otherlv_5= 'month' ( (lv_month_6_0= ruleEIntegerObject ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==56) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalMyDsl.g:1659:4: otherlv_5= 'month' ( (lv_month_6_0= ruleEIntegerObject ) )
                    {
                    otherlv_5=(Token)match(input,56,FOLLOW_60); 

                    				newLeafNode(otherlv_5, grammarAccess.getTimestampAccess().getMonthKeyword_4_0());
                    			
                    // InternalMyDsl.g:1663:4: ( (lv_month_6_0= ruleEIntegerObject ) )
                    // InternalMyDsl.g:1664:5: (lv_month_6_0= ruleEIntegerObject )
                    {
                    // InternalMyDsl.g:1664:5: (lv_month_6_0= ruleEIntegerObject )
                    // InternalMyDsl.g:1665:6: lv_month_6_0= ruleEIntegerObject
                    {

                    						newCompositeNode(grammarAccess.getTimestampAccess().getMonthEIntegerObjectParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_62);
                    lv_month_6_0=ruleEIntegerObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimestampRule());
                    						}
                    						set(
                    							current,
                    							"month",
                    							lv_month_6_0,
                    							"org.xtext.mydsl.MyDsl.EIntegerObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1683:3: (otherlv_7= 'day' ( (lv_day_8_0= ruleEIntegerObject ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==57) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalMyDsl.g:1684:4: otherlv_7= 'day' ( (lv_day_8_0= ruleEIntegerObject ) )
                    {
                    otherlv_7=(Token)match(input,57,FOLLOW_60); 

                    				newLeafNode(otherlv_7, grammarAccess.getTimestampAccess().getDayKeyword_5_0());
                    			
                    // InternalMyDsl.g:1688:4: ( (lv_day_8_0= ruleEIntegerObject ) )
                    // InternalMyDsl.g:1689:5: (lv_day_8_0= ruleEIntegerObject )
                    {
                    // InternalMyDsl.g:1689:5: (lv_day_8_0= ruleEIntegerObject )
                    // InternalMyDsl.g:1690:6: lv_day_8_0= ruleEIntegerObject
                    {

                    						newCompositeNode(grammarAccess.getTimestampAccess().getDayEIntegerObjectParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_63);
                    lv_day_8_0=ruleEIntegerObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimestampRule());
                    						}
                    						set(
                    							current,
                    							"day",
                    							lv_day_8_0,
                    							"org.xtext.mydsl.MyDsl.EIntegerObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1708:3: (otherlv_9= 'hour' ( (lv_hour_10_0= ruleEIntegerObject ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==58) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMyDsl.g:1709:4: otherlv_9= 'hour' ( (lv_hour_10_0= ruleEIntegerObject ) )
                    {
                    otherlv_9=(Token)match(input,58,FOLLOW_60); 

                    				newLeafNode(otherlv_9, grammarAccess.getTimestampAccess().getHourKeyword_6_0());
                    			
                    // InternalMyDsl.g:1713:4: ( (lv_hour_10_0= ruleEIntegerObject ) )
                    // InternalMyDsl.g:1714:5: (lv_hour_10_0= ruleEIntegerObject )
                    {
                    // InternalMyDsl.g:1714:5: (lv_hour_10_0= ruleEIntegerObject )
                    // InternalMyDsl.g:1715:6: lv_hour_10_0= ruleEIntegerObject
                    {

                    						newCompositeNode(grammarAccess.getTimestampAccess().getHourEIntegerObjectParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_64);
                    lv_hour_10_0=ruleEIntegerObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimestampRule());
                    						}
                    						set(
                    							current,
                    							"hour",
                    							lv_hour_10_0,
                    							"org.xtext.mydsl.MyDsl.EIntegerObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1733:3: (otherlv_11= 'minute' ( (lv_minute_12_0= ruleEIntegerObject ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==59) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalMyDsl.g:1734:4: otherlv_11= 'minute' ( (lv_minute_12_0= ruleEIntegerObject ) )
                    {
                    otherlv_11=(Token)match(input,59,FOLLOW_60); 

                    				newLeafNode(otherlv_11, grammarAccess.getTimestampAccess().getMinuteKeyword_7_0());
                    			
                    // InternalMyDsl.g:1738:4: ( (lv_minute_12_0= ruleEIntegerObject ) )
                    // InternalMyDsl.g:1739:5: (lv_minute_12_0= ruleEIntegerObject )
                    {
                    // InternalMyDsl.g:1739:5: (lv_minute_12_0= ruleEIntegerObject )
                    // InternalMyDsl.g:1740:6: lv_minute_12_0= ruleEIntegerObject
                    {

                    						newCompositeNode(grammarAccess.getTimestampAccess().getMinuteEIntegerObjectParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_65);
                    lv_minute_12_0=ruleEIntegerObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimestampRule());
                    						}
                    						set(
                    							current,
                    							"minute",
                    							lv_minute_12_0,
                    							"org.xtext.mydsl.MyDsl.EIntegerObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1758:3: (otherlv_13= 'second' ( (lv_second_14_0= ruleEIntegerObject ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==60) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalMyDsl.g:1759:4: otherlv_13= 'second' ( (lv_second_14_0= ruleEIntegerObject ) )
                    {
                    otherlv_13=(Token)match(input,60,FOLLOW_60); 

                    				newLeafNode(otherlv_13, grammarAccess.getTimestampAccess().getSecondKeyword_8_0());
                    			
                    // InternalMyDsl.g:1763:4: ( (lv_second_14_0= ruleEIntegerObject ) )
                    // InternalMyDsl.g:1764:5: (lv_second_14_0= ruleEIntegerObject )
                    {
                    // InternalMyDsl.g:1764:5: (lv_second_14_0= ruleEIntegerObject )
                    // InternalMyDsl.g:1765:6: lv_second_14_0= ruleEIntegerObject
                    {

                    						newCompositeNode(grammarAccess.getTimestampAccess().getSecondEIntegerObjectParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_second_14_0=ruleEIntegerObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimestampRule());
                    						}
                    						set(
                    							current,
                    							"second",
                    							lv_second_14_0,
                    							"org.xtext.mydsl.MyDsl.EIntegerObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getTimestampAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimestamp"


    // $ANTLR start "entryRuleRelationship"
    // InternalMyDsl.g:1791:1: entryRuleRelationship returns [EObject current=null] : iv_ruleRelationship= ruleRelationship EOF ;
    public final EObject entryRuleRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationship = null;


        try {
            // InternalMyDsl.g:1791:53: (iv_ruleRelationship= ruleRelationship EOF )
            // InternalMyDsl.g:1792:2: iv_ruleRelationship= ruleRelationship EOF
            {
             newCompositeNode(grammarAccess.getRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationship=ruleRelationship();

            state._fsp--;

             current =iv_ruleRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationship"


    // $ANTLR start "ruleRelationship"
    // InternalMyDsl.g:1798:1: ruleRelationship returns [EObject current=null] : (otherlv_0= 'Relationship' otherlv_1= '{' (otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) )? otherlv_4= 'character' ( ( ruleEString ) ) otherlv_6= 'relationshiptype' ( ( ruleEString ) ) otherlv_8= '}' ) ;
    public final EObject ruleRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_description_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1804:2: ( (otherlv_0= 'Relationship' otherlv_1= '{' (otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) )? otherlv_4= 'character' ( ( ruleEString ) ) otherlv_6= 'relationshiptype' ( ( ruleEString ) ) otherlv_8= '}' ) )
            // InternalMyDsl.g:1805:2: (otherlv_0= 'Relationship' otherlv_1= '{' (otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) )? otherlv_4= 'character' ( ( ruleEString ) ) otherlv_6= 'relationshiptype' ( ( ruleEString ) ) otherlv_8= '}' )
            {
            // InternalMyDsl.g:1805:2: (otherlv_0= 'Relationship' otherlv_1= '{' (otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) )? otherlv_4= 'character' ( ( ruleEString ) ) otherlv_6= 'relationshiptype' ( ( ruleEString ) ) otherlv_8= '}' )
            // InternalMyDsl.g:1806:3: otherlv_0= 'Relationship' otherlv_1= '{' (otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) )? otherlv_4= 'character' ( ( ruleEString ) ) otherlv_6= 'relationshiptype' ( ( ruleEString ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRelationshipAccess().getRelationshipKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_66); 

            			newLeafNode(otherlv_1, grammarAccess.getRelationshipAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1814:3: (otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==42) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMyDsl.g:1815:4: otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getRelationshipAccess().getDescriptionKeyword_2_0());
                    			
                    // InternalMyDsl.g:1819:4: ( (lv_description_3_0= ruleEString ) )
                    // InternalMyDsl.g:1820:5: (lv_description_3_0= ruleEString )
                    {
                    // InternalMyDsl.g:1820:5: (lv_description_3_0= ruleEString )
                    // InternalMyDsl.g:1821:6: lv_description_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getRelationshipAccess().getDescriptionEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_description_3_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelationshipRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_3_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_23); 

            			newLeafNode(otherlv_4, grammarAccess.getRelationshipAccess().getCharacterKeyword_3());
            		
            // InternalMyDsl.g:1843:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1844:4: ( ruleEString )
            {
            // InternalMyDsl.g:1844:4: ( ruleEString )
            // InternalMyDsl.g:1845:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRelationshipAccess().getCharacterCharacterCrossReference_4_0());
            				
            pushFollow(FOLLOW_68);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_6, grammarAccess.getRelationshipAccess().getRelationshiptypeKeyword_5());
            		
            // InternalMyDsl.g:1863:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1864:4: ( ruleEString )
            {
            // InternalMyDsl.g:1864:4: ( ruleEString )
            // InternalMyDsl.g:1865:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRelationshipAccess().getRelationshiptypeRelationshipTypeCrossReference_6_0());
            				
            pushFollow(FOLLOW_18);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getRelationshipAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationship"


    // $ANTLR start "entryRuleBeliefSystem"
    // InternalMyDsl.g:1887:1: entryRuleBeliefSystem returns [EObject current=null] : iv_ruleBeliefSystem= ruleBeliefSystem EOF ;
    public final EObject entryRuleBeliefSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefSystem = null;


        try {
            // InternalMyDsl.g:1887:53: (iv_ruleBeliefSystem= ruleBeliefSystem EOF )
            // InternalMyDsl.g:1888:2: iv_ruleBeliefSystem= ruleBeliefSystem EOF
            {
             newCompositeNode(grammarAccess.getBeliefSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeliefSystem=ruleBeliefSystem();

            state._fsp--;

             current =iv_ruleBeliefSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBeliefSystem"


    // $ANTLR start "ruleBeliefSystem"
    // InternalMyDsl.g:1894:1: ruleBeliefSystem returns [EObject current=null] : (otherlv_0= 'BeliefSystem' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'beliefsystemtype' ( ( ruleEString ) ) (otherlv_7= 'is_believed_by' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' )? (otherlv_13= 'related_events' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= '}' ) ;
    public final EObject ruleBeliefSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1900:2: ( (otherlv_0= 'BeliefSystem' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'beliefsystemtype' ( ( ruleEString ) ) (otherlv_7= 'is_believed_by' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' )? (otherlv_13= 'related_events' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= '}' ) )
            // InternalMyDsl.g:1901:2: (otherlv_0= 'BeliefSystem' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'beliefsystemtype' ( ( ruleEString ) ) (otherlv_7= 'is_believed_by' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' )? (otherlv_13= 'related_events' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= '}' )
            {
            // InternalMyDsl.g:1901:2: (otherlv_0= 'BeliefSystem' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'beliefsystemtype' ( ( ruleEString ) ) (otherlv_7= 'is_believed_by' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' )? (otherlv_13= 'related_events' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= '}' )
            // InternalMyDsl.g:1902:3: otherlv_0= 'BeliefSystem' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'beliefsystemtype' ( ( ruleEString ) ) (otherlv_7= 'is_believed_by' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' )? (otherlv_13= 'related_events' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )? otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getBeliefSystemAccess().getBeliefSystemKeyword_0());
            		
            // InternalMyDsl.g:1906:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1907:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1907:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1908:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getBeliefSystemAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBeliefSystemRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_69); 

            			newLeafNode(otherlv_2, grammarAccess.getBeliefSystemAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1929:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==42) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalMyDsl.g:1930:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getBeliefSystemAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1934:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1935:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1935:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1936:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getBeliefSystemAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_70);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBeliefSystemRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FOLLOW_23); 

            			newLeafNode(otherlv_5, grammarAccess.getBeliefSystemAccess().getBeliefsystemtypeKeyword_4());
            		
            // InternalMyDsl.g:1958:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1959:4: ( ruleEString )
            {
            // InternalMyDsl.g:1959:4: ( ruleEString )
            // InternalMyDsl.g:1960:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBeliefSystemRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBeliefSystemAccess().getBeliefsystemtypeBeliefSystemTypeCrossReference_5_0());
            				
            pushFollow(FOLLOW_71);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1974:3: (otherlv_7= 'is_believed_by' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==63) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalMyDsl.g:1975:4: otherlv_7= 'is_believed_by' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')'
                    {
                    otherlv_7=(Token)match(input,63,FOLLOW_49); 

                    				newLeafNode(otherlv_7, grammarAccess.getBeliefSystemAccess().getIs_believed_byKeyword_6_0());
                    			
                    otherlv_8=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_8, grammarAccess.getBeliefSystemAccess().getLeftParenthesisKeyword_6_1());
                    			
                    // InternalMyDsl.g:1983:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1984:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1984:5: ( ruleEString )
                    // InternalMyDsl.g:1985:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBeliefSystemRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getBeliefSystemAccess().getIs_believed_byCharacterCrossReference_6_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1999:4: (otherlv_10= ',' ( ( ruleEString ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==23) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalMyDsl.g:2000:5: otherlv_10= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_10=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getBeliefSystemAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMyDsl.g:2004:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:2005:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:2005:6: ( ruleEString )
                    	    // InternalMyDsl.g:2006:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getBeliefSystemRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getBeliefSystemAccess().getIs_believed_byCharacterCrossReference_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,48,FOLLOW_72); 

                    				newLeafNode(otherlv_12, grammarAccess.getBeliefSystemAccess().getRightParenthesisKeyword_6_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:2026:3: (otherlv_13= 'related_events' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==64) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalMyDsl.g:2027:4: otherlv_13= 'related_events' otherlv_14= '(' ( ( ruleEString ) ) (otherlv_16= ',' ( ( ruleEString ) ) )* otherlv_18= ')'
                    {
                    otherlv_13=(Token)match(input,64,FOLLOW_49); 

                    				newLeafNode(otherlv_13, grammarAccess.getBeliefSystemAccess().getRelated_eventsKeyword_7_0());
                    			
                    otherlv_14=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_14, grammarAccess.getBeliefSystemAccess().getLeftParenthesisKeyword_7_1());
                    			
                    // InternalMyDsl.g:2035:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:2036:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:2036:5: ( ruleEString )
                    // InternalMyDsl.g:2037:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBeliefSystemRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getBeliefSystemAccess().getRelated_eventsEventCrossReference_7_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:2051:4: (otherlv_16= ',' ( ( ruleEString ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==23) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalMyDsl.g:2052:5: otherlv_16= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_16=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getBeliefSystemAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMyDsl.g:2056:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:2057:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:2057:6: ( ruleEString )
                    	    // InternalMyDsl.g:2058:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getBeliefSystemRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getBeliefSystemAccess().getRelated_eventsEventCrossReference_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,48,FOLLOW_18); 

                    				newLeafNode(otherlv_18, grammarAccess.getBeliefSystemAccess().getRightParenthesisKeyword_7_4());
                    			

                    }
                    break;

            }

            otherlv_19=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getBeliefSystemAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBeliefSystem"


    // $ANTLR start "entryRulePoliticalEntity"
    // InternalMyDsl.g:2086:1: entryRulePoliticalEntity returns [EObject current=null] : iv_rulePoliticalEntity= rulePoliticalEntity EOF ;
    public final EObject entryRulePoliticalEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoliticalEntity = null;


        try {
            // InternalMyDsl.g:2086:56: (iv_rulePoliticalEntity= rulePoliticalEntity EOF )
            // InternalMyDsl.g:2087:2: iv_rulePoliticalEntity= rulePoliticalEntity EOF
            {
             newCompositeNode(grammarAccess.getPoliticalEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoliticalEntity=rulePoliticalEntity();

            state._fsp--;

             current =iv_rulePoliticalEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoliticalEntity"


    // $ANTLR start "rulePoliticalEntity"
    // InternalMyDsl.g:2093:1: rulePoliticalEntity returns [EObject current=null] : (otherlv_0= 'PoliticalEntity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'beliefsystem' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'members' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? otherlv_17= 'is_concerned_with' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' otherlv_23= '}' ) ;
    public final EObject rulePoliticalEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2099:2: ( (otherlv_0= 'PoliticalEntity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'beliefsystem' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'members' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? otherlv_17= 'is_concerned_with' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' otherlv_23= '}' ) )
            // InternalMyDsl.g:2100:2: (otherlv_0= 'PoliticalEntity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'beliefsystem' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'members' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? otherlv_17= 'is_concerned_with' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' otherlv_23= '}' )
            {
            // InternalMyDsl.g:2100:2: (otherlv_0= 'PoliticalEntity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'beliefsystem' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'members' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? otherlv_17= 'is_concerned_with' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' otherlv_23= '}' )
            // InternalMyDsl.g:2101:3: otherlv_0= 'PoliticalEntity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'beliefsystem' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )? (otherlv_11= 'members' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? otherlv_17= 'is_concerned_with' otherlv_18= '(' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= ')' otherlv_23= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getPoliticalEntityAccess().getPoliticalEntityKeyword_0());
            		
            // InternalMyDsl.g:2105:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2106:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2106:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2107:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPoliticalEntityAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPoliticalEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_73); 

            			newLeafNode(otherlv_2, grammarAccess.getPoliticalEntityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2128:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==42) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalMyDsl.g:2129:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getPoliticalEntityAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2133:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2134:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2134:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2135:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPoliticalEntityAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_74);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPoliticalEntityRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2153:3: (otherlv_5= 'beliefsystem' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==36) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalMyDsl.g:2154:4: otherlv_5= 'beliefsystem' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')'
                    {
                    otherlv_5=(Token)match(input,36,FOLLOW_49); 

                    				newLeafNode(otherlv_5, grammarAccess.getPoliticalEntityAccess().getBeliefsystemKeyword_4_0());
                    			
                    otherlv_6=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_6, grammarAccess.getPoliticalEntityAccess().getLeftParenthesisKeyword_4_1());
                    			
                    // InternalMyDsl.g:2162:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:2163:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:2163:5: ( ruleEString )
                    // InternalMyDsl.g:2164:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPoliticalEntityRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPoliticalEntityAccess().getBeliefsystemBeliefSystemCrossReference_4_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:2178:4: (otherlv_8= ',' ( ( ruleEString ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==23) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalMyDsl.g:2179:5: otherlv_8= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_8=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getPoliticalEntityAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalMyDsl.g:2183:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:2184:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:2184:6: ( ruleEString )
                    	    // InternalMyDsl.g:2185:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getPoliticalEntityRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getPoliticalEntityAccess().getBeliefsystemBeliefSystemCrossReference_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,48,FOLLOW_75); 

                    				newLeafNode(otherlv_10, grammarAccess.getPoliticalEntityAccess().getRightParenthesisKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:2205:3: (otherlv_11= 'members' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==66) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalMyDsl.g:2206:4: otherlv_11= 'members' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')'
                    {
                    otherlv_11=(Token)match(input,66,FOLLOW_49); 

                    				newLeafNode(otherlv_11, grammarAccess.getPoliticalEntityAccess().getMembersKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_12, grammarAccess.getPoliticalEntityAccess().getLeftParenthesisKeyword_5_1());
                    			
                    // InternalMyDsl.g:2214:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:2215:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:2215:5: ( ruleEString )
                    // InternalMyDsl.g:2216:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPoliticalEntityRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPoliticalEntityAccess().getMembersCharacterCrossReference_5_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:2230:4: (otherlv_14= ',' ( ( ruleEString ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==23) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalMyDsl.g:2231:5: otherlv_14= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_14=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getPoliticalEntityAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalMyDsl.g:2235:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:2236:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:2236:6: ( ruleEString )
                    	    // InternalMyDsl.g:2237:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getPoliticalEntityRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getPoliticalEntityAccess().getMembersCharacterCrossReference_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,48,FOLLOW_76); 

                    				newLeafNode(otherlv_16, grammarAccess.getPoliticalEntityAccess().getRightParenthesisKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_17=(Token)match(input,67,FOLLOW_49); 

            			newLeafNode(otherlv_17, grammarAccess.getPoliticalEntityAccess().getIs_concerned_withKeyword_6());
            		
            otherlv_18=(Token)match(input,47,FOLLOW_23); 

            			newLeafNode(otherlv_18, grammarAccess.getPoliticalEntityAccess().getLeftParenthesisKeyword_7());
            		
            // InternalMyDsl.g:2265:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2266:4: ( ruleEString )
            {
            // InternalMyDsl.g:2266:4: ( ruleEString )
            // InternalMyDsl.g:2267:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPoliticalEntityRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPoliticalEntityAccess().getIs_concerned_withLocationCrossReference_8_0());
            				
            pushFollow(FOLLOW_50);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:2281:3: (otherlv_20= ',' ( ( ruleEString ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==23) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalMyDsl.g:2282:4: otherlv_20= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_20=(Token)match(input,23,FOLLOW_23); 

            	    				newLeafNode(otherlv_20, grammarAccess.getPoliticalEntityAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalMyDsl.g:2286:4: ( ( ruleEString ) )
            	    // InternalMyDsl.g:2287:5: ( ruleEString )
            	    {
            	    // InternalMyDsl.g:2287:5: ( ruleEString )
            	    // InternalMyDsl.g:2288:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getPoliticalEntityRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getPoliticalEntityAccess().getIs_concerned_withLocationCrossReference_9_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            otherlv_22=(Token)match(input,48,FOLLOW_18); 

            			newLeafNode(otherlv_22, grammarAccess.getPoliticalEntityAccess().getRightParenthesisKeyword_10());
            		
            otherlv_23=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_23, grammarAccess.getPoliticalEntityAccess().getRightCurlyBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoliticalEntity"


    // $ANTLR start "entryRuleAnimalSpeciesType"
    // InternalMyDsl.g:2315:1: entryRuleAnimalSpeciesType returns [EObject current=null] : iv_ruleAnimalSpeciesType= ruleAnimalSpeciesType EOF ;
    public final EObject entryRuleAnimalSpeciesType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnimalSpeciesType = null;


        try {
            // InternalMyDsl.g:2315:58: (iv_ruleAnimalSpeciesType= ruleAnimalSpeciesType EOF )
            // InternalMyDsl.g:2316:2: iv_ruleAnimalSpeciesType= ruleAnimalSpeciesType EOF
            {
             newCompositeNode(grammarAccess.getAnimalSpeciesTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnimalSpeciesType=ruleAnimalSpeciesType();

            state._fsp--;

             current =iv_ruleAnimalSpeciesType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnimalSpeciesType"


    // $ANTLR start "ruleAnimalSpeciesType"
    // InternalMyDsl.g:2322:1: ruleAnimalSpeciesType returns [EObject current=null] : ( () otherlv_1= 'AnimalSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' ) ;
    public final EObject ruleAnimalSpeciesType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2328:2: ( ( () otherlv_1= 'AnimalSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' ) )
            // InternalMyDsl.g:2329:2: ( () otherlv_1= 'AnimalSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' )
            {
            // InternalMyDsl.g:2329:2: ( () otherlv_1= 'AnimalSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' )
            // InternalMyDsl.g:2330:3: () otherlv_1= 'AnimalSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}'
            {
            // InternalMyDsl.g:2330:3: ()
            // InternalMyDsl.g:2331:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAnimalSpeciesTypeAccess().getAnimalSpeciesTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,68,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getAnimalSpeciesTypeAccess().getAnimalSpeciesTypeKeyword_1());
            		
            // InternalMyDsl.g:2341:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:2342:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:2342:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:2343:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAnimalSpeciesTypeAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAnimalSpeciesTypeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_77); 

            			newLeafNode(otherlv_3, grammarAccess.getAnimalSpeciesTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMyDsl.g:2364:3: (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==42) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalMyDsl.g:2365:4: otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_4, grammarAccess.getAnimalSpeciesTypeAccess().getDescriptionKeyword_4_0());
                    			
                    // InternalMyDsl.g:2369:4: ( (lv_description_5_0= ruleEString ) )
                    // InternalMyDsl.g:2370:5: (lv_description_5_0= ruleEString )
                    {
                    // InternalMyDsl.g:2370:5: (lv_description_5_0= ruleEString )
                    // InternalMyDsl.g:2371:6: lv_description_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAnimalSpeciesTypeAccess().getDescriptionEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_78);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAnimalSpeciesTypeRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2389:3: (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==69) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalMyDsl.g:2390:4: otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')'
                    {
                    otherlv_6=(Token)match(input,69,FOLLOW_49); 

                    				newLeafNode(otherlv_6, grammarAccess.getAnimalSpeciesTypeAccess().getNatural_habitatKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getAnimalSpeciesTypeAccess().getLeftParenthesisKeyword_5_1());
                    			
                    // InternalMyDsl.g:2398:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:2399:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:2399:5: ( ruleEString )
                    // InternalMyDsl.g:2400:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAnimalSpeciesTypeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAnimalSpeciesTypeAccess().getNatural_habitatLocationCrossReference_5_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:2414:4: (otherlv_9= ',' ( ( ruleEString ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==23) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalMyDsl.g:2415:5: otherlv_9= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getAnimalSpeciesTypeAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalMyDsl.g:2419:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:2420:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:2420:6: ( ruleEString )
                    	    // InternalMyDsl.g:2421:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getAnimalSpeciesTypeRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getAnimalSpeciesTypeAccess().getNatural_habitatLocationCrossReference_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,48,FOLLOW_18); 

                    				newLeafNode(otherlv_11, grammarAccess.getAnimalSpeciesTypeAccess().getRightParenthesisKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_12=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getAnimalSpeciesTypeAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnimalSpeciesType"


    // $ANTLR start "entryRuleEIntegerObject"
    // InternalMyDsl.g:2449:1: entryRuleEIntegerObject returns [String current=null] : iv_ruleEIntegerObject= ruleEIntegerObject EOF ;
    public final String entryRuleEIntegerObject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEIntegerObject = null;


        try {
            // InternalMyDsl.g:2449:54: (iv_ruleEIntegerObject= ruleEIntegerObject EOF )
            // InternalMyDsl.g:2450:2: iv_ruleEIntegerObject= ruleEIntegerObject EOF
            {
             newCompositeNode(grammarAccess.getEIntegerObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEIntegerObject=ruleEIntegerObject();

            state._fsp--;

             current =iv_ruleEIntegerObject.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEIntegerObject"


    // $ANTLR start "ruleEIntegerObject"
    // InternalMyDsl.g:2456:1: ruleEIntegerObject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEIntegerObject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2462:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMyDsl.g:2463:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMyDsl.g:2463:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMyDsl.g:2464:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMyDsl.g:2464:3: (kw= '-' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==70) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalMyDsl.g:2465:4: kw= '-'
                    {
                    kw=(Token)match(input,70,FOLLOW_79); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntegerObjectAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntegerObjectAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEIntegerObject"


    // $ANTLR start "entryRuleRelationshipType"
    // InternalMyDsl.g:2482:1: entryRuleRelationshipType returns [EObject current=null] : iv_ruleRelationshipType= ruleRelationshipType EOF ;
    public final EObject entryRuleRelationshipType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationshipType = null;


        try {
            // InternalMyDsl.g:2482:57: (iv_ruleRelationshipType= ruleRelationshipType EOF )
            // InternalMyDsl.g:2483:2: iv_ruleRelationshipType= ruleRelationshipType EOF
            {
             newCompositeNode(grammarAccess.getRelationshipTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationshipType=ruleRelationshipType();

            state._fsp--;

             current =iv_ruleRelationshipType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationshipType"


    // $ANTLR start "ruleRelationshipType"
    // InternalMyDsl.g:2489:1: ruleRelationshipType returns [EObject current=null] : ( () otherlv_1= 'RelationshipType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleRelationshipType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2495:2: ( ( () otherlv_1= 'RelationshipType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}' ) )
            // InternalMyDsl.g:2496:2: ( () otherlv_1= 'RelationshipType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}' )
            {
            // InternalMyDsl.g:2496:2: ( () otherlv_1= 'RelationshipType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}' )
            // InternalMyDsl.g:2497:3: () otherlv_1= 'RelationshipType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}'
            {
            // InternalMyDsl.g:2497:3: ()
            // InternalMyDsl.g:2498:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRelationshipTypeAccess().getRelationshipTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,71,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getRelationshipTypeAccess().getRelationshipTypeKeyword_1());
            		
            // InternalMyDsl.g:2508:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:2509:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:2509:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:2510:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRelationshipTypeAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationshipTypeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_80); 

            			newLeafNode(otherlv_3, grammarAccess.getRelationshipTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMyDsl.g:2531:3: (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==42) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalMyDsl.g:2532:4: otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_4, grammarAccess.getRelationshipTypeAccess().getDescriptionKeyword_4_0());
                    			
                    // InternalMyDsl.g:2536:4: ( (lv_description_5_0= ruleEString ) )
                    // InternalMyDsl.g:2537:5: (lv_description_5_0= ruleEString )
                    {
                    // InternalMyDsl.g:2537:5: (lv_description_5_0= ruleEString )
                    // InternalMyDsl.g:2538:6: lv_description_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getRelationshipTypeAccess().getDescriptionEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelationshipTypeRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getRelationshipTypeAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationshipType"


    // $ANTLR start "entryRuleBeliefSystemType"
    // InternalMyDsl.g:2564:1: entryRuleBeliefSystemType returns [EObject current=null] : iv_ruleBeliefSystemType= ruleBeliefSystemType EOF ;
    public final EObject entryRuleBeliefSystemType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefSystemType = null;


        try {
            // InternalMyDsl.g:2564:57: (iv_ruleBeliefSystemType= ruleBeliefSystemType EOF )
            // InternalMyDsl.g:2565:2: iv_ruleBeliefSystemType= ruleBeliefSystemType EOF
            {
             newCompositeNode(grammarAccess.getBeliefSystemTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeliefSystemType=ruleBeliefSystemType();

            state._fsp--;

             current =iv_ruleBeliefSystemType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBeliefSystemType"


    // $ANTLR start "ruleBeliefSystemType"
    // InternalMyDsl.g:2571:1: ruleBeliefSystemType returns [EObject current=null] : ( ( (lv_canHaveEvent_0_0= 'canHaveEvent' ) ) otherlv_1= 'BeliefSystemType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleBeliefSystemType() throws RecognitionException {
        EObject current = null;

        Token lv_canHaveEvent_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2577:2: ( ( ( (lv_canHaveEvent_0_0= 'canHaveEvent' ) ) otherlv_1= 'BeliefSystemType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}' ) )
            // InternalMyDsl.g:2578:2: ( ( (lv_canHaveEvent_0_0= 'canHaveEvent' ) ) otherlv_1= 'BeliefSystemType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}' )
            {
            // InternalMyDsl.g:2578:2: ( ( (lv_canHaveEvent_0_0= 'canHaveEvent' ) ) otherlv_1= 'BeliefSystemType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}' )
            // InternalMyDsl.g:2579:3: ( (lv_canHaveEvent_0_0= 'canHaveEvent' ) ) otherlv_1= 'BeliefSystemType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? otherlv_6= '}'
            {
            // InternalMyDsl.g:2579:3: ( (lv_canHaveEvent_0_0= 'canHaveEvent' ) )
            // InternalMyDsl.g:2580:4: (lv_canHaveEvent_0_0= 'canHaveEvent' )
            {
            // InternalMyDsl.g:2580:4: (lv_canHaveEvent_0_0= 'canHaveEvent' )
            // InternalMyDsl.g:2581:5: lv_canHaveEvent_0_0= 'canHaveEvent'
            {
            lv_canHaveEvent_0_0=(Token)match(input,72,FOLLOW_81); 

            					newLeafNode(lv_canHaveEvent_0_0, grammarAccess.getBeliefSystemTypeAccess().getCanHaveEventCanHaveEventKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBeliefSystemTypeRule());
            					}
            					setWithLastConsumed(current, "canHaveEvent", lv_canHaveEvent_0_0 != null, "canHaveEvent");
            				

            }


            }

            otherlv_1=(Token)match(input,73,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getBeliefSystemTypeAccess().getBeliefSystemTypeKeyword_1());
            		
            // InternalMyDsl.g:2597:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:2598:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:2598:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:2599:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getBeliefSystemTypeAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBeliefSystemTypeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_80); 

            			newLeafNode(otherlv_3, grammarAccess.getBeliefSystemTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMyDsl.g:2620:3: (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==42) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalMyDsl.g:2621:4: otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_4, grammarAccess.getBeliefSystemTypeAccess().getDescriptionKeyword_4_0());
                    			
                    // InternalMyDsl.g:2625:4: ( (lv_description_5_0= ruleEString ) )
                    // InternalMyDsl.g:2626:5: (lv_description_5_0= ruleEString )
                    {
                    // InternalMyDsl.g:2626:5: (lv_description_5_0= ruleEString )
                    // InternalMyDsl.g:2627:6: lv_description_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getBeliefSystemTypeAccess().getDescriptionEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBeliefSystemTypeRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getBeliefSystemTypeAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBeliefSystemType"


    // $ANTLR start "entryRuleEvent"
    // InternalMyDsl.g:2653:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalMyDsl.g:2653:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalMyDsl.g:2654:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalMyDsl.g:2660:1: ruleEvent returns [EObject current=null] : ( () otherlv_1= 'Event' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'location' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? (otherlv_12= 'presences' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' )? (otherlv_18= 'related_beliefs' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' )? otherlv_24= '}' ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2666:2: ( ( () otherlv_1= 'Event' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'location' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? (otherlv_12= 'presences' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' )? (otherlv_18= 'related_beliefs' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' )? otherlv_24= '}' ) )
            // InternalMyDsl.g:2667:2: ( () otherlv_1= 'Event' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'location' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? (otherlv_12= 'presences' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' )? (otherlv_18= 'related_beliefs' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' )? otherlv_24= '}' )
            {
            // InternalMyDsl.g:2667:2: ( () otherlv_1= 'Event' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'location' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? (otherlv_12= 'presences' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' )? (otherlv_18= 'related_beliefs' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' )? otherlv_24= '}' )
            // InternalMyDsl.g:2668:3: () otherlv_1= 'Event' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'location' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? (otherlv_12= 'presences' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' )? (otherlv_18= 'related_beliefs' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' )? otherlv_24= '}'
            {
            // InternalMyDsl.g:2668:3: ()
            // InternalMyDsl.g:2669:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEventAccess().getEventAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,74,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getEventAccess().getEventKeyword_1());
            		
            // InternalMyDsl.g:2679:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:2680:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:2680:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:2681:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getEventAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEventRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_82); 

            			newLeafNode(otherlv_3, grammarAccess.getEventAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMyDsl.g:2702:3: (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==42) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalMyDsl.g:2703:4: otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_4, grammarAccess.getEventAccess().getDescriptionKeyword_4_0());
                    			
                    // InternalMyDsl.g:2707:4: ( (lv_description_5_0= ruleEString ) )
                    // InternalMyDsl.g:2708:5: (lv_description_5_0= ruleEString )
                    {
                    // InternalMyDsl.g:2708:5: (lv_description_5_0= ruleEString )
                    // InternalMyDsl.g:2709:6: lv_description_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getEventAccess().getDescriptionEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_83);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2727:3: (otherlv_6= 'location' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==32) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalMyDsl.g:2728:4: otherlv_6= 'location' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')'
                    {
                    otherlv_6=(Token)match(input,32,FOLLOW_49); 

                    				newLeafNode(otherlv_6, grammarAccess.getEventAccess().getLocationKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getEventAccess().getLeftParenthesisKeyword_5_1());
                    			
                    // InternalMyDsl.g:2736:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:2737:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:2737:5: ( ruleEString )
                    // InternalMyDsl.g:2738:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEventRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getEventAccess().getLocationLocationCrossReference_5_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:2752:4: (otherlv_9= ',' ( ( ruleEString ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==23) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalMyDsl.g:2753:5: otherlv_9= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getEventAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalMyDsl.g:2757:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:2758:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:2758:6: ( ruleEString )
                    	    // InternalMyDsl.g:2759:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getEventRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getEventAccess().getLocationLocationCrossReference_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,48,FOLLOW_84); 

                    				newLeafNode(otherlv_11, grammarAccess.getEventAccess().getRightParenthesisKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:2779:3: (otherlv_12= 'presences' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==75) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalMyDsl.g:2780:4: otherlv_12= 'presences' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')'
                    {
                    otherlv_12=(Token)match(input,75,FOLLOW_49); 

                    				newLeafNode(otherlv_12, grammarAccess.getEventAccess().getPresencesKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_13, grammarAccess.getEventAccess().getLeftParenthesisKeyword_6_1());
                    			
                    // InternalMyDsl.g:2788:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:2789:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:2789:5: ( ruleEString )
                    // InternalMyDsl.g:2790:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEventRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getEventAccess().getPresencesPresenceCrossReference_6_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:2804:4: (otherlv_15= ',' ( ( ruleEString ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==23) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalMyDsl.g:2805:5: otherlv_15= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_15=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getEventAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMyDsl.g:2809:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:2810:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:2810:6: ( ruleEString )
                    	    // InternalMyDsl.g:2811:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getEventRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getEventAccess().getPresencesPresenceCrossReference_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,48,FOLLOW_85); 

                    				newLeafNode(otherlv_17, grammarAccess.getEventAccess().getRightParenthesisKeyword_6_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:2831:3: (otherlv_18= 'related_beliefs' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==76) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalMyDsl.g:2832:4: otherlv_18= 'related_beliefs' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')'
                    {
                    otherlv_18=(Token)match(input,76,FOLLOW_49); 

                    				newLeafNode(otherlv_18, grammarAccess.getEventAccess().getRelated_beliefsKeyword_7_0());
                    			
                    otherlv_19=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_19, grammarAccess.getEventAccess().getLeftParenthesisKeyword_7_1());
                    			
                    // InternalMyDsl.g:2840:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:2841:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:2841:5: ( ruleEString )
                    // InternalMyDsl.g:2842:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEventRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getEventAccess().getRelated_beliefsBeliefSystemCrossReference_7_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:2856:4: (otherlv_21= ',' ( ( ruleEString ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==23) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalMyDsl.g:2857:5: otherlv_21= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_21=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_21, grammarAccess.getEventAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMyDsl.g:2861:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:2862:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:2862:6: ( ruleEString )
                    	    // InternalMyDsl.g:2863:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getEventRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getEventAccess().getRelated_beliefsBeliefSystemCrossReference_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,48,FOLLOW_18); 

                    				newLeafNode(otherlv_23, grammarAccess.getEventAccess().getRightParenthesisKeyword_7_4());
                    			

                    }
                    break;

            }

            otherlv_24=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_24, grammarAccess.getEventAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleLocation"
    // InternalMyDsl.g:2891:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // InternalMyDsl.g:2891:49: (iv_ruleLocation= ruleLocation EOF )
            // InternalMyDsl.g:2892:2: iv_ruleLocation= ruleLocation EOF
            {
             newCompositeNode(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocation=ruleLocation();

            state._fsp--;

             current =iv_ruleLocation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocation"


    // $ANTLR start "ruleLocation"
    // InternalMyDsl.g:2898:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'Location' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'flag' ( (lv_flag_6_0= ruleImageURL ) ) )? otherlv_7= 'locationtype' ( ( ruleEString ) ) (otherlv_9= 'plants_that_occur' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' )? (otherlv_15= 'animals_that_occur' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' )? (otherlv_21= 'events' otherlv_22= '(' ( ( ruleEString ) ) (otherlv_24= ',' ( ( ruleEString ) ) )* otherlv_26= ')' )? otherlv_27= 'coordinates' otherlv_28= '{' ( (lv_coordinates_29_0= ruleCoordinate ) ) (otherlv_30= ',' ( (lv_coordinates_31_0= ruleCoordinate ) ) )* otherlv_32= '}' otherlv_33= '}' ) ;
    public final EObject ruleLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        AntlrDatatypeRuleToken lv_flag_6_0 = null;

        EObject lv_coordinates_29_0 = null;

        EObject lv_coordinates_31_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2904:2: ( (otherlv_0= 'Location' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'flag' ( (lv_flag_6_0= ruleImageURL ) ) )? otherlv_7= 'locationtype' ( ( ruleEString ) ) (otherlv_9= 'plants_that_occur' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' )? (otherlv_15= 'animals_that_occur' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' )? (otherlv_21= 'events' otherlv_22= '(' ( ( ruleEString ) ) (otherlv_24= ',' ( ( ruleEString ) ) )* otherlv_26= ')' )? otherlv_27= 'coordinates' otherlv_28= '{' ( (lv_coordinates_29_0= ruleCoordinate ) ) (otherlv_30= ',' ( (lv_coordinates_31_0= ruleCoordinate ) ) )* otherlv_32= '}' otherlv_33= '}' ) )
            // InternalMyDsl.g:2905:2: (otherlv_0= 'Location' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'flag' ( (lv_flag_6_0= ruleImageURL ) ) )? otherlv_7= 'locationtype' ( ( ruleEString ) ) (otherlv_9= 'plants_that_occur' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' )? (otherlv_15= 'animals_that_occur' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' )? (otherlv_21= 'events' otherlv_22= '(' ( ( ruleEString ) ) (otherlv_24= ',' ( ( ruleEString ) ) )* otherlv_26= ')' )? otherlv_27= 'coordinates' otherlv_28= '{' ( (lv_coordinates_29_0= ruleCoordinate ) ) (otherlv_30= ',' ( (lv_coordinates_31_0= ruleCoordinate ) ) )* otherlv_32= '}' otherlv_33= '}' )
            {
            // InternalMyDsl.g:2905:2: (otherlv_0= 'Location' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'flag' ( (lv_flag_6_0= ruleImageURL ) ) )? otherlv_7= 'locationtype' ( ( ruleEString ) ) (otherlv_9= 'plants_that_occur' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' )? (otherlv_15= 'animals_that_occur' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' )? (otherlv_21= 'events' otherlv_22= '(' ( ( ruleEString ) ) (otherlv_24= ',' ( ( ruleEString ) ) )* otherlv_26= ')' )? otherlv_27= 'coordinates' otherlv_28= '{' ( (lv_coordinates_29_0= ruleCoordinate ) ) (otherlv_30= ',' ( (lv_coordinates_31_0= ruleCoordinate ) ) )* otherlv_32= '}' otherlv_33= '}' )
            // InternalMyDsl.g:2906:3: otherlv_0= 'Location' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? (otherlv_5= 'flag' ( (lv_flag_6_0= ruleImageURL ) ) )? otherlv_7= 'locationtype' ( ( ruleEString ) ) (otherlv_9= 'plants_that_occur' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' )? (otherlv_15= 'animals_that_occur' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' )? (otherlv_21= 'events' otherlv_22= '(' ( ( ruleEString ) ) (otherlv_24= ',' ( ( ruleEString ) ) )* otherlv_26= ')' )? otherlv_27= 'coordinates' otherlv_28= '{' ( (lv_coordinates_29_0= ruleCoordinate ) ) (otherlv_30= ',' ( (lv_coordinates_31_0= ruleCoordinate ) ) )* otherlv_32= '}' otherlv_33= '}'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLocationKeyword_0());
            		
            // InternalMyDsl.g:2910:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2911:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2911:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2912:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_86); 

            			newLeafNode(otherlv_2, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2933:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==42) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalMyDsl.g:2934:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getLocationAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2938:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2939:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2939:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2940:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getLocationAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_87);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLocationRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2958:3: (otherlv_5= 'flag' ( (lv_flag_6_0= ruleImageURL ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==78) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalMyDsl.g:2959:4: otherlv_5= 'flag' ( (lv_flag_6_0= ruleImageURL ) )
                    {
                    otherlv_5=(Token)match(input,78,FOLLOW_88); 

                    				newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getFlagKeyword_4_0());
                    			
                    // InternalMyDsl.g:2963:4: ( (lv_flag_6_0= ruleImageURL ) )
                    // InternalMyDsl.g:2964:5: (lv_flag_6_0= ruleImageURL )
                    {
                    // InternalMyDsl.g:2964:5: (lv_flag_6_0= ruleImageURL )
                    // InternalMyDsl.g:2965:6: lv_flag_6_0= ruleImageURL
                    {

                    						newCompositeNode(grammarAccess.getLocationAccess().getFlagImageURLParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_89);
                    lv_flag_6_0=ruleImageURL();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLocationRule());
                    						}
                    						set(
                    							current,
                    							"flag",
                    							lv_flag_6_0,
                    							"org.xtext.mydsl.MyDsl.ImageURL");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,28,FOLLOW_23); 

            			newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getLocationtypeKeyword_5());
            		
            // InternalMyDsl.g:2987:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2988:4: ( ruleEString )
            {
            // InternalMyDsl.g:2988:4: ( ruleEString )
            // InternalMyDsl.g:2989:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLocationAccess().getLocationtypeLocationTypeCrossReference_6_0());
            				
            pushFollow(FOLLOW_90);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:3003:3: (otherlv_9= 'plants_that_occur' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==79) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalMyDsl.g:3004:4: otherlv_9= 'plants_that_occur' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')'
                    {
                    otherlv_9=(Token)match(input,79,FOLLOW_49); 

                    				newLeafNode(otherlv_9, grammarAccess.getLocationAccess().getPlants_that_occurKeyword_7_0());
                    			
                    otherlv_10=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_10, grammarAccess.getLocationAccess().getLeftParenthesisKeyword_7_1());
                    			
                    // InternalMyDsl.g:3012:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:3013:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:3013:5: ( ruleEString )
                    // InternalMyDsl.g:3014:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLocationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getLocationAccess().getPlants_that_occurPlantSpeciesTypeCrossReference_7_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:3028:4: (otherlv_12= ',' ( ( ruleEString ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==23) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalMyDsl.g:3029:5: otherlv_12= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getLocationAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMyDsl.g:3033:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:3034:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:3034:6: ( ruleEString )
                    	    // InternalMyDsl.g:3035:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getLocationRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getLocationAccess().getPlants_that_occurPlantSpeciesTypeCrossReference_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,48,FOLLOW_91); 

                    				newLeafNode(otherlv_14, grammarAccess.getLocationAccess().getRightParenthesisKeyword_7_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:3055:3: (otherlv_15= 'animals_that_occur' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==80) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalMyDsl.g:3056:4: otherlv_15= 'animals_that_occur' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')'
                    {
                    otherlv_15=(Token)match(input,80,FOLLOW_49); 

                    				newLeafNode(otherlv_15, grammarAccess.getLocationAccess().getAnimals_that_occurKeyword_8_0());
                    			
                    otherlv_16=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_16, grammarAccess.getLocationAccess().getLeftParenthesisKeyword_8_1());
                    			
                    // InternalMyDsl.g:3064:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:3065:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:3065:5: ( ruleEString )
                    // InternalMyDsl.g:3066:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLocationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getLocationAccess().getAnimals_that_occurAnimalSpeciesTypeCrossReference_8_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:3080:4: (otherlv_18= ',' ( ( ruleEString ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==23) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalMyDsl.g:3081:5: otherlv_18= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_18=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getLocationAccess().getCommaKeyword_8_3_0());
                    	    				
                    	    // InternalMyDsl.g:3085:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:3086:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:3086:6: ( ruleEString )
                    	    // InternalMyDsl.g:3087:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getLocationRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getLocationAccess().getAnimals_that_occurAnimalSpeciesTypeCrossReference_8_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,48,FOLLOW_92); 

                    				newLeafNode(otherlv_20, grammarAccess.getLocationAccess().getRightParenthesisKeyword_8_4());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:3107:3: (otherlv_21= 'events' otherlv_22= '(' ( ( ruleEString ) ) (otherlv_24= ',' ( ( ruleEString ) ) )* otherlv_26= ')' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==81) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalMyDsl.g:3108:4: otherlv_21= 'events' otherlv_22= '(' ( ( ruleEString ) ) (otherlv_24= ',' ( ( ruleEString ) ) )* otherlv_26= ')'
                    {
                    otherlv_21=(Token)match(input,81,FOLLOW_49); 

                    				newLeafNode(otherlv_21, grammarAccess.getLocationAccess().getEventsKeyword_9_0());
                    			
                    otherlv_22=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_22, grammarAccess.getLocationAccess().getLeftParenthesisKeyword_9_1());
                    			
                    // InternalMyDsl.g:3116:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:3117:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:3117:5: ( ruleEString )
                    // InternalMyDsl.g:3118:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLocationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getLocationAccess().getEventsEventCrossReference_9_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:3132:4: (otherlv_24= ',' ( ( ruleEString ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==23) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalMyDsl.g:3133:5: otherlv_24= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_24=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_24, grammarAccess.getLocationAccess().getCommaKeyword_9_3_0());
                    	    				
                    	    // InternalMyDsl.g:3137:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:3138:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:3138:6: ( ruleEString )
                    	    // InternalMyDsl.g:3139:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getLocationRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getLocationAccess().getEventsEventCrossReference_9_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,48,FOLLOW_93); 

                    				newLeafNode(otherlv_26, grammarAccess.getLocationAccess().getRightParenthesisKeyword_9_4());
                    			

                    }
                    break;

            }

            otherlv_27=(Token)match(input,82,FOLLOW_3); 

            			newLeafNode(otherlv_27, grammarAccess.getLocationAccess().getCoordinatesKeyword_10());
            		
            otherlv_28=(Token)match(input,12,FOLLOW_94); 

            			newLeafNode(otherlv_28, grammarAccess.getLocationAccess().getLeftCurlyBracketKeyword_11());
            		
            // InternalMyDsl.g:3167:3: ( (lv_coordinates_29_0= ruleCoordinate ) )
            // InternalMyDsl.g:3168:4: (lv_coordinates_29_0= ruleCoordinate )
            {
            // InternalMyDsl.g:3168:4: (lv_coordinates_29_0= ruleCoordinate )
            // InternalMyDsl.g:3169:5: lv_coordinates_29_0= ruleCoordinate
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getCoordinatesCoordinateParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_21);
            lv_coordinates_29_0=ruleCoordinate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					add(
            						current,
            						"coordinates",
            						lv_coordinates_29_0,
            						"org.xtext.mydsl.MyDsl.Coordinate");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:3186:3: (otherlv_30= ',' ( (lv_coordinates_31_0= ruleCoordinate ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==23) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalMyDsl.g:3187:4: otherlv_30= ',' ( (lv_coordinates_31_0= ruleCoordinate ) )
            	    {
            	    otherlv_30=(Token)match(input,23,FOLLOW_94); 

            	    				newLeafNode(otherlv_30, grammarAccess.getLocationAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalMyDsl.g:3191:4: ( (lv_coordinates_31_0= ruleCoordinate ) )
            	    // InternalMyDsl.g:3192:5: (lv_coordinates_31_0= ruleCoordinate )
            	    {
            	    // InternalMyDsl.g:3192:5: (lv_coordinates_31_0= ruleCoordinate )
            	    // InternalMyDsl.g:3193:6: lv_coordinates_31_0= ruleCoordinate
            	    {

            	    						newCompositeNode(grammarAccess.getLocationAccess().getCoordinatesCoordinateParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_coordinates_31_0=ruleCoordinate();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLocationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"coordinates",
            	    							lv_coordinates_31_0,
            	    							"org.xtext.mydsl.MyDsl.Coordinate");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            otherlv_32=(Token)match(input,20,FOLLOW_18); 

            			newLeafNode(otherlv_32, grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_14());
            		
            otherlv_33=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_33, grammarAccess.getLocationAccess().getRightCurlyBracketKeyword_15());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocation"


    // $ANTLR start "entryRulePresence"
    // InternalMyDsl.g:3223:1: entryRulePresence returns [EObject current=null] : iv_rulePresence= rulePresence EOF ;
    public final EObject entryRulePresence() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePresence = null;


        try {
            // InternalMyDsl.g:3223:49: (iv_rulePresence= rulePresence EOF )
            // InternalMyDsl.g:3224:2: iv_rulePresence= rulePresence EOF
            {
             newCompositeNode(grammarAccess.getPresenceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePresence=rulePresence();

            state._fsp--;

             current =iv_rulePresence; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePresence"


    // $ANTLR start "rulePresence"
    // InternalMyDsl.g:3230:1: rulePresence returns [EObject current=null] : (otherlv_0= 'Presence' otherlv_1= '{' otherlv_2= 'location' ( ( ruleEString ) ) otherlv_4= 'character' ( ( ruleEString ) ) (otherlv_6= 'event' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= 'timeframe' ( (lv_timeframe_13_0= ruleTimeframe ) ) otherlv_14= '}' ) ;
    public final EObject rulePresence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_timeframe_13_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3236:2: ( (otherlv_0= 'Presence' otherlv_1= '{' otherlv_2= 'location' ( ( ruleEString ) ) otherlv_4= 'character' ( ( ruleEString ) ) (otherlv_6= 'event' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= 'timeframe' ( (lv_timeframe_13_0= ruleTimeframe ) ) otherlv_14= '}' ) )
            // InternalMyDsl.g:3237:2: (otherlv_0= 'Presence' otherlv_1= '{' otherlv_2= 'location' ( ( ruleEString ) ) otherlv_4= 'character' ( ( ruleEString ) ) (otherlv_6= 'event' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= 'timeframe' ( (lv_timeframe_13_0= ruleTimeframe ) ) otherlv_14= '}' )
            {
            // InternalMyDsl.g:3237:2: (otherlv_0= 'Presence' otherlv_1= '{' otherlv_2= 'location' ( ( ruleEString ) ) otherlv_4= 'character' ( ( ruleEString ) ) (otherlv_6= 'event' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= 'timeframe' ( (lv_timeframe_13_0= ruleTimeframe ) ) otherlv_14= '}' )
            // InternalMyDsl.g:3238:3: otherlv_0= 'Presence' otherlv_1= '{' otherlv_2= 'location' ( ( ruleEString ) ) otherlv_4= 'character' ( ( ruleEString ) ) (otherlv_6= 'event' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= 'timeframe' ( (lv_timeframe_13_0= ruleTimeframe ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPresenceAccess().getPresenceKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_95); 

            			newLeafNode(otherlv_1, grammarAccess.getPresenceAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getPresenceAccess().getLocationKeyword_2());
            		
            // InternalMyDsl.g:3250:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3251:4: ( ruleEString )
            {
            // InternalMyDsl.g:3251:4: ( ruleEString )
            // InternalMyDsl.g:3252:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPresenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPresenceAccess().getLocationLocationCrossReference_3_0());
            				
            pushFollow(FOLLOW_67);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_23); 

            			newLeafNode(otherlv_4, grammarAccess.getPresenceAccess().getCharacterKeyword_4());
            		
            // InternalMyDsl.g:3270:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3271:4: ( ruleEString )
            {
            // InternalMyDsl.g:3271:4: ( ruleEString )
            // InternalMyDsl.g:3272:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPresenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPresenceAccess().getCharacterCharacterCrossReference_5_0());
            				
            pushFollow(FOLLOW_96);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:3286:3: (otherlv_6= 'event' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==38) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalMyDsl.g:3287:4: otherlv_6= 'event' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')'
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_49); 

                    				newLeafNode(otherlv_6, grammarAccess.getPresenceAccess().getEventKeyword_6_0());
                    			
                    otherlv_7=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getPresenceAccess().getLeftParenthesisKeyword_6_1());
                    			
                    // InternalMyDsl.g:3295:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:3296:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:3296:5: ( ruleEString )
                    // InternalMyDsl.g:3297:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPresenceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPresenceAccess().getEventEventCrossReference_6_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:3311:4: (otherlv_9= ',' ( ( ruleEString ) ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==23) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalMyDsl.g:3312:5: otherlv_9= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getPresenceAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMyDsl.g:3316:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:3317:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:3317:6: ( ruleEString )
                    	    // InternalMyDsl.g:3318:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getPresenceRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getPresenceAccess().getEventEventCrossReference_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,48,FOLLOW_97); 

                    				newLeafNode(otherlv_11, grammarAccess.getPresenceAccess().getRightParenthesisKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_12=(Token)match(input,84,FOLLOW_98); 

            			newLeafNode(otherlv_12, grammarAccess.getPresenceAccess().getTimeframeKeyword_7());
            		
            // InternalMyDsl.g:3342:3: ( (lv_timeframe_13_0= ruleTimeframe ) )
            // InternalMyDsl.g:3343:4: (lv_timeframe_13_0= ruleTimeframe )
            {
            // InternalMyDsl.g:3343:4: (lv_timeframe_13_0= ruleTimeframe )
            // InternalMyDsl.g:3344:5: lv_timeframe_13_0= ruleTimeframe
            {

            					newCompositeNode(grammarAccess.getPresenceAccess().getTimeframeTimeframeParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_18);
            lv_timeframe_13_0=ruleTimeframe();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPresenceRule());
            					}
            					set(
            						current,
            						"timeframe",
            						lv_timeframe_13_0,
            						"org.xtext.mydsl.MyDsl.Timeframe");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getPresenceAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePresence"


    // $ANTLR start "entryRuleImageURL"
    // InternalMyDsl.g:3369:1: entryRuleImageURL returns [String current=null] : iv_ruleImageURL= ruleImageURL EOF ;
    public final String entryRuleImageURL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImageURL = null;


        try {
            // InternalMyDsl.g:3369:48: (iv_ruleImageURL= ruleImageURL EOF )
            // InternalMyDsl.g:3370:2: iv_ruleImageURL= ruleImageURL EOF
            {
             newCompositeNode(grammarAccess.getImageURLRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImageURL=ruleImageURL();

            state._fsp--;

             current =iv_ruleImageURL.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImageURL"


    // $ANTLR start "ruleImageURL"
    // InternalMyDsl.g:3376:1: ruleImageURL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'ImageURL' ;
    public final AntlrDatatypeRuleToken ruleImageURL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3382:2: (kw= 'ImageURL' )
            // InternalMyDsl.g:3383:2: kw= 'ImageURL'
            {
            kw=(Token)match(input,85,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getImageURLAccess().getImageURLKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImageURL"


    // $ANTLR start "entryRuleLocationType"
    // InternalMyDsl.g:3391:1: entryRuleLocationType returns [EObject current=null] : iv_ruleLocationType= ruleLocationType EOF ;
    public final EObject entryRuleLocationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocationType = null;


        try {
            // InternalMyDsl.g:3391:53: (iv_ruleLocationType= ruleLocationType EOF )
            // InternalMyDsl.g:3392:2: iv_ruleLocationType= ruleLocationType EOF
            {
             newCompositeNode(grammarAccess.getLocationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocationType=ruleLocationType();

            state._fsp--;

             current =iv_ruleLocationType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocationType"


    // $ANTLR start "ruleLocationType"
    // InternalMyDsl.g:3398:1: ruleLocationType returns [EObject current=null] : ( () otherlv_1= 'LocationType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'contains' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' ) ;
    public final EObject ruleLocationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3404:2: ( ( () otherlv_1= 'LocationType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'contains' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' ) )
            // InternalMyDsl.g:3405:2: ( () otherlv_1= 'LocationType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'contains' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' )
            {
            // InternalMyDsl.g:3405:2: ( () otherlv_1= 'LocationType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'contains' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' )
            // InternalMyDsl.g:3406:3: () otherlv_1= 'LocationType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'contains' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}'
            {
            // InternalMyDsl.g:3406:3: ()
            // InternalMyDsl.g:3407:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLocationTypeAccess().getLocationTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,86,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getLocationTypeAccess().getLocationTypeKeyword_1());
            		
            // InternalMyDsl.g:3417:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:3418:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:3418:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:3419:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLocationTypeAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationTypeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_99); 

            			newLeafNode(otherlv_3, grammarAccess.getLocationTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMyDsl.g:3440:3: (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==42) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalMyDsl.g:3441:4: otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_4, grammarAccess.getLocationTypeAccess().getDescriptionKeyword_4_0());
                    			
                    // InternalMyDsl.g:3445:4: ( (lv_description_5_0= ruleEString ) )
                    // InternalMyDsl.g:3446:5: (lv_description_5_0= ruleEString )
                    {
                    // InternalMyDsl.g:3446:5: (lv_description_5_0= ruleEString )
                    // InternalMyDsl.g:3447:6: lv_description_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getLocationTypeAccess().getDescriptionEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_100);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLocationTypeRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:3465:3: (otherlv_6= 'contains' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==87) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalMyDsl.g:3466:4: otherlv_6= 'contains' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')'
                    {
                    otherlv_6=(Token)match(input,87,FOLLOW_49); 

                    				newLeafNode(otherlv_6, grammarAccess.getLocationTypeAccess().getContainsKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getLocationTypeAccess().getLeftParenthesisKeyword_5_1());
                    			
                    // InternalMyDsl.g:3474:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:3475:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:3475:5: ( ruleEString )
                    // InternalMyDsl.g:3476:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLocationTypeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getLocationTypeAccess().getContainsLocationTypeCrossReference_5_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:3490:4: (otherlv_9= ',' ( ( ruleEString ) ) )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==23) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // InternalMyDsl.g:3491:5: otherlv_9= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getLocationTypeAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalMyDsl.g:3495:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:3496:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:3496:6: ( ruleEString )
                    	    // InternalMyDsl.g:3497:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getLocationTypeRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getLocationTypeAccess().getContainsLocationTypeCrossReference_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop82;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,48,FOLLOW_18); 

                    				newLeafNode(otherlv_11, grammarAccess.getLocationTypeAccess().getRightParenthesisKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_12=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getLocationTypeAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocationType"


    // $ANTLR start "entryRulePlantSpeciesType"
    // InternalMyDsl.g:3525:1: entryRulePlantSpeciesType returns [EObject current=null] : iv_rulePlantSpeciesType= rulePlantSpeciesType EOF ;
    public final EObject entryRulePlantSpeciesType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlantSpeciesType = null;


        try {
            // InternalMyDsl.g:3525:57: (iv_rulePlantSpeciesType= rulePlantSpeciesType EOF )
            // InternalMyDsl.g:3526:2: iv_rulePlantSpeciesType= rulePlantSpeciesType EOF
            {
             newCompositeNode(grammarAccess.getPlantSpeciesTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlantSpeciesType=rulePlantSpeciesType();

            state._fsp--;

             current =iv_rulePlantSpeciesType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlantSpeciesType"


    // $ANTLR start "rulePlantSpeciesType"
    // InternalMyDsl.g:3532:1: rulePlantSpeciesType returns [EObject current=null] : ( () otherlv_1= 'PlantSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' ) ;
    public final EObject rulePlantSpeciesType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3538:2: ( ( () otherlv_1= 'PlantSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' ) )
            // InternalMyDsl.g:3539:2: ( () otherlv_1= 'PlantSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' )
            {
            // InternalMyDsl.g:3539:2: ( () otherlv_1= 'PlantSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}' )
            // InternalMyDsl.g:3540:3: () otherlv_1= 'PlantSpeciesType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )? (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )? otherlv_12= '}'
            {
            // InternalMyDsl.g:3540:3: ()
            // InternalMyDsl.g:3541:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPlantSpeciesTypeAccess().getPlantSpeciesTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,88,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getPlantSpeciesTypeAccess().getPlantSpeciesTypeKeyword_1());
            		
            // InternalMyDsl.g:3551:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:3552:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:3552:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:3553:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPlantSpeciesTypeAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPlantSpeciesTypeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_77); 

            			newLeafNode(otherlv_3, grammarAccess.getPlantSpeciesTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMyDsl.g:3574:3: (otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==42) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalMyDsl.g:3575:4: otherlv_4= 'description' ( (lv_description_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,42,FOLLOW_23); 

                    				newLeafNode(otherlv_4, grammarAccess.getPlantSpeciesTypeAccess().getDescriptionKeyword_4_0());
                    			
                    // InternalMyDsl.g:3579:4: ( (lv_description_5_0= ruleEString ) )
                    // InternalMyDsl.g:3580:5: (lv_description_5_0= ruleEString )
                    {
                    // InternalMyDsl.g:3580:5: (lv_description_5_0= ruleEString )
                    // InternalMyDsl.g:3581:6: lv_description_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPlantSpeciesTypeAccess().getDescriptionEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_78);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPlantSpeciesTypeRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.xtext.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:3599:3: (otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==69) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalMyDsl.g:3600:4: otherlv_6= 'natural_habitat' otherlv_7= '(' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ')'
                    {
                    otherlv_6=(Token)match(input,69,FOLLOW_49); 

                    				newLeafNode(otherlv_6, grammarAccess.getPlantSpeciesTypeAccess().getNatural_habitatKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,47,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getPlantSpeciesTypeAccess().getLeftParenthesisKeyword_5_1());
                    			
                    // InternalMyDsl.g:3608:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:3609:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:3609:5: ( ruleEString )
                    // InternalMyDsl.g:3610:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPlantSpeciesTypeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPlantSpeciesTypeAccess().getNatural_habitatLocationCrossReference_5_2_0());
                    					
                    pushFollow(FOLLOW_50);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:3624:4: (otherlv_9= ',' ( ( ruleEString ) ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==23) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // InternalMyDsl.g:3625:5: otherlv_9= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getPlantSpeciesTypeAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalMyDsl.g:3629:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:3630:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:3630:6: ( ruleEString )
                    	    // InternalMyDsl.g:3631:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getPlantSpeciesTypeRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getPlantSpeciesTypeAccess().getNatural_habitatLocationCrossReference_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop85;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,48,FOLLOW_18); 

                    				newLeafNode(otherlv_11, grammarAccess.getPlantSpeciesTypeAccess().getRightParenthesisKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_12=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getPlantSpeciesTypeAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlantSpeciesType"


    // $ANTLR start "entryRuleCoordinate"
    // InternalMyDsl.g:3659:1: entryRuleCoordinate returns [EObject current=null] : iv_ruleCoordinate= ruleCoordinate EOF ;
    public final EObject entryRuleCoordinate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoordinate = null;


        try {
            // InternalMyDsl.g:3659:51: (iv_ruleCoordinate= ruleCoordinate EOF )
            // InternalMyDsl.g:3660:2: iv_ruleCoordinate= ruleCoordinate EOF
            {
             newCompositeNode(grammarAccess.getCoordinateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCoordinate=ruleCoordinate();

            state._fsp--;

             current =iv_ruleCoordinate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCoordinate"


    // $ANTLR start "ruleCoordinate"
    // InternalMyDsl.g:3666:1: ruleCoordinate returns [EObject current=null] : (otherlv_0= 'Coordinate' otherlv_1= '{' otherlv_2= 'latitude' ( (lv_latitude_3_0= ruleEDoubleObject ) ) otherlv_4= 'longitude' ( (lv_longitude_5_0= ruleEDoubleObject ) ) otherlv_6= '}' ) ;
    public final EObject ruleCoordinate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_latitude_3_0 = null;

        AntlrDatatypeRuleToken lv_longitude_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3672:2: ( (otherlv_0= 'Coordinate' otherlv_1= '{' otherlv_2= 'latitude' ( (lv_latitude_3_0= ruleEDoubleObject ) ) otherlv_4= 'longitude' ( (lv_longitude_5_0= ruleEDoubleObject ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:3673:2: (otherlv_0= 'Coordinate' otherlv_1= '{' otherlv_2= 'latitude' ( (lv_latitude_3_0= ruleEDoubleObject ) ) otherlv_4= 'longitude' ( (lv_longitude_5_0= ruleEDoubleObject ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:3673:2: (otherlv_0= 'Coordinate' otherlv_1= '{' otherlv_2= 'latitude' ( (lv_latitude_3_0= ruleEDoubleObject ) ) otherlv_4= 'longitude' ( (lv_longitude_5_0= ruleEDoubleObject ) ) otherlv_6= '}' )
            // InternalMyDsl.g:3674:3: otherlv_0= 'Coordinate' otherlv_1= '{' otherlv_2= 'latitude' ( (lv_latitude_3_0= ruleEDoubleObject ) ) otherlv_4= 'longitude' ( (lv_longitude_5_0= ruleEDoubleObject ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCoordinateAccess().getCoordinateKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_101); 

            			newLeafNode(otherlv_1, grammarAccess.getCoordinateAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,90,FOLLOW_102); 

            			newLeafNode(otherlv_2, grammarAccess.getCoordinateAccess().getLatitudeKeyword_2());
            		
            // InternalMyDsl.g:3686:3: ( (lv_latitude_3_0= ruleEDoubleObject ) )
            // InternalMyDsl.g:3687:4: (lv_latitude_3_0= ruleEDoubleObject )
            {
            // InternalMyDsl.g:3687:4: (lv_latitude_3_0= ruleEDoubleObject )
            // InternalMyDsl.g:3688:5: lv_latitude_3_0= ruleEDoubleObject
            {

            					newCompositeNode(grammarAccess.getCoordinateAccess().getLatitudeEDoubleObjectParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_103);
            lv_latitude_3_0=ruleEDoubleObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCoordinateRule());
            					}
            					set(
            						current,
            						"latitude",
            						lv_latitude_3_0,
            						"org.xtext.mydsl.MyDsl.EDoubleObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,91,FOLLOW_102); 

            			newLeafNode(otherlv_4, grammarAccess.getCoordinateAccess().getLongitudeKeyword_4());
            		
            // InternalMyDsl.g:3709:3: ( (lv_longitude_5_0= ruleEDoubleObject ) )
            // InternalMyDsl.g:3710:4: (lv_longitude_5_0= ruleEDoubleObject )
            {
            // InternalMyDsl.g:3710:4: (lv_longitude_5_0= ruleEDoubleObject )
            // InternalMyDsl.g:3711:5: lv_longitude_5_0= ruleEDoubleObject
            {

            					newCompositeNode(grammarAccess.getCoordinateAccess().getLongitudeEDoubleObjectParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_18);
            lv_longitude_5_0=ruleEDoubleObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCoordinateRule());
            					}
            					set(
            						current,
            						"longitude",
            						lv_longitude_5_0,
            						"org.xtext.mydsl.MyDsl.EDoubleObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCoordinateAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCoordinate"


    // $ANTLR start "entryRuleEDoubleObject"
    // InternalMyDsl.g:3736:1: entryRuleEDoubleObject returns [String current=null] : iv_ruleEDoubleObject= ruleEDoubleObject EOF ;
    public final String entryRuleEDoubleObject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDoubleObject = null;


        try {
            // InternalMyDsl.g:3736:53: (iv_ruleEDoubleObject= ruleEDoubleObject EOF )
            // InternalMyDsl.g:3737:2: iv_ruleEDoubleObject= ruleEDoubleObject EOF
            {
             newCompositeNode(grammarAccess.getEDoubleObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEDoubleObject=ruleEDoubleObject();

            state._fsp--;

             current =iv_ruleEDoubleObject.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDoubleObject"


    // $ANTLR start "ruleEDoubleObject"
    // InternalMyDsl.g:3743:1: ruleEDoubleObject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDoubleObject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3749:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalMyDsl.g:3750:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalMyDsl.g:3750:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalMyDsl.g:3751:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalMyDsl.g:3751:3: (kw= '-' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==70) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalMyDsl.g:3752:4: kw= '-'
                    {
                    kw=(Token)match(input,70,FOLLOW_104); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleObjectAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:3758:3: (this_INT_1= RULE_INT )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_INT) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalMyDsl.g:3759:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_105); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleObjectAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,92,FOLLOW_79); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleObjectAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_106); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleObjectAccess().getINTTerminalRuleCall_3());
            		
            // InternalMyDsl.g:3779:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( ((LA91_0>=93 && LA91_0<=94)) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalMyDsl.g:3780:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalMyDsl.g:3780:4: (kw= 'E' | kw= 'e' )
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==93) ) {
                        alt89=1;
                    }
                    else if ( (LA89_0==94) ) {
                        alt89=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 89, 0, input);

                        throw nvae;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalMyDsl.g:3781:5: kw= 'E'
                            {
                            kw=(Token)match(input,93,FOLLOW_60); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleObjectAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalMyDsl.g:3787:5: kw= 'e'
                            {
                            kw=(Token)match(input,94,FOLLOW_60); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleObjectAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalMyDsl.g:3793:4: (kw= '-' )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==70) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // InternalMyDsl.g:3794:5: kw= '-'
                            {
                            kw=(Token)match(input,70,FOLLOW_79); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleObjectAccess().getHyphenMinusKeyword_4_1());
                            				

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_7);
                    			

                    				newLeafNode(this_INT_7, grammarAccess.getEDoubleObjectAccess().getINTTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDoubleObject"


    // $ANTLR start "entryRuleTimeframe"
    // InternalMyDsl.g:3812:1: entryRuleTimeframe returns [EObject current=null] : iv_ruleTimeframe= ruleTimeframe EOF ;
    public final EObject entryRuleTimeframe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeframe = null;


        try {
            // InternalMyDsl.g:3812:50: (iv_ruleTimeframe= ruleTimeframe EOF )
            // InternalMyDsl.g:3813:2: iv_ruleTimeframe= ruleTimeframe EOF
            {
             newCompositeNode(grammarAccess.getTimeframeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeframe=ruleTimeframe();

            state._fsp--;

             current =iv_ruleTimeframe; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeframe"


    // $ANTLR start "ruleTimeframe"
    // InternalMyDsl.g:3819:1: ruleTimeframe returns [EObject current=null] : (otherlv_0= 'Timeframe' otherlv_1= '{' otherlv_2= 'start' ( (lv_start_3_0= ruleTimestamp ) ) otherlv_4= 'end' ( (lv_end_5_0= ruleTimestamp ) ) otherlv_6= '}' ) ;
    public final EObject ruleTimeframe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_start_3_0 = null;

        EObject lv_end_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3825:2: ( (otherlv_0= 'Timeframe' otherlv_1= '{' otherlv_2= 'start' ( (lv_start_3_0= ruleTimestamp ) ) otherlv_4= 'end' ( (lv_end_5_0= ruleTimestamp ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:3826:2: (otherlv_0= 'Timeframe' otherlv_1= '{' otherlv_2= 'start' ( (lv_start_3_0= ruleTimestamp ) ) otherlv_4= 'end' ( (lv_end_5_0= ruleTimestamp ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:3826:2: (otherlv_0= 'Timeframe' otherlv_1= '{' otherlv_2= 'start' ( (lv_start_3_0= ruleTimestamp ) ) otherlv_4= 'end' ( (lv_end_5_0= ruleTimestamp ) ) otherlv_6= '}' )
            // InternalMyDsl.g:3827:3: otherlv_0= 'Timeframe' otherlv_1= '{' otherlv_2= 'start' ( (lv_start_3_0= ruleTimestamp ) ) otherlv_4= 'end' ( (lv_end_5_0= ruleTimestamp ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeframeAccess().getTimeframeKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_107); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeframeAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,96,FOLLOW_55); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeframeAccess().getStartKeyword_2());
            		
            // InternalMyDsl.g:3839:3: ( (lv_start_3_0= ruleTimestamp ) )
            // InternalMyDsl.g:3840:4: (lv_start_3_0= ruleTimestamp )
            {
            // InternalMyDsl.g:3840:4: (lv_start_3_0= ruleTimestamp )
            // InternalMyDsl.g:3841:5: lv_start_3_0= ruleTimestamp
            {

            					newCompositeNode(grammarAccess.getTimeframeAccess().getStartTimestampParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_108);
            lv_start_3_0=ruleTimestamp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeframeRule());
            					}
            					set(
            						current,
            						"start",
            						lv_start_3_0,
            						"org.xtext.mydsl.MyDsl.Timestamp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,97,FOLLOW_55); 

            			newLeafNode(otherlv_4, grammarAccess.getTimeframeAccess().getEndKeyword_4());
            		
            // InternalMyDsl.g:3862:3: ( (lv_end_5_0= ruleTimestamp ) )
            // InternalMyDsl.g:3863:4: (lv_end_5_0= ruleTimestamp )
            {
            // InternalMyDsl.g:3863:4: (lv_end_5_0= ruleTimestamp )
            // InternalMyDsl.g:3864:5: lv_end_5_0= ruleTimestamp
            {

            					newCompositeNode(grammarAccess.getTimeframeAccess().getEndTimestampParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_18);
            lv_end_5_0=ruleTimestamp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeframeRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_5_0,
            						"org.xtext.mydsl.MyDsl.Timestamp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getTimeframeAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeframe"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000007C100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000078100000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000070100000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000060100000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000040100000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000001000100000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000004000100000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000010000100000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x003E7C0004100000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x003E780004100000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x003E700004100000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x003E600004100000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x003E400004100000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0001000000800000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x003E000004100000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x003C000004100000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0038000004100000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0038000000100000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0030000000100000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0020000000100000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x1F80000000100000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000040L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x1F00000000100000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x1E00000000100000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x1C00000000100000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x1800000000100000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x1000000000100000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000040000400000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000040020000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000000000100000L,0x0000000000000001L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000001L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000041000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000001000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000040000100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000040000100000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000040100100000L,0x0000000000001800L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000100100000L,0x0000000000001800L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000100000L,0x0000000000001800L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000100000L,0x0000000000001000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000040010000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000010000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000000000078000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x0000000000070000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000004000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000040000100000L,0x0000000000800000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000100000L,0x0000000000800000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000040L,0x0000000010000040L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000040L,0x0000000010000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000002L,0x0000000060000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});

}