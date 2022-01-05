package com.sabeshkin;

import static org.junit.Assert.*;
import org.junit.Test;


public class SelectLeadingNameTest {
        @Test
        public void selectLeadingNameTest_First() {
            String playerName = Tennis.selectLeadingName(2,1);
            assertEquals(
                    "First player has an advantage",playerName);
        }

        @Test
        public void selectLeadingNameTest_Second() {
            String playerName = Tennis.selectLeadingName(1,2);
            assertEquals(
                    "Second player has an advantage",playerName);
        }
//
//        @Test
//        public void selectLeadingNameTest_Equals_Score() {
//            String playerName = Tennis.selectLeadingName(2,2);
//            assertEquals(
//                    "Equals score",playerName);
//        }

}

