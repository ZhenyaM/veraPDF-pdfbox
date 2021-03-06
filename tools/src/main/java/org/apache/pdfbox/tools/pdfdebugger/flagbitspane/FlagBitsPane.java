/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pdfbox.tools.pdfdebugger.flagbitspane;

import javax.swing.JPanel;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

/**
 * @author Khyrul Bashar
 *
 * A class that displays flag bits in a table in detail.
 */
public class FlagBitsPane
{
    private FlagBitsPaneView view;

    /**
     * Constructor.
     * @param dictionary COSDictionary instance.
     * @param flagType COSName instance.
     */
    public FlagBitsPane(final COSDictionary dictionary, COSName flagType)
    {
        createPane(dictionary, flagType);
    }

    private void createPane(final COSDictionary dictionary, final COSName flagType)
    {
        Flag flag;
        if (flagType.equals(COSName.FLAGS))
        {
            flag = new FontFlag(dictionary);
            view = new FlagBitsPaneView(
                    flag.getFlagType(), flag.getFlagValue(), flag.getFlagBits(), flag.getColumnNames());
        }

        if (flagType.equals(COSName.F))
        {
            flag = new AnnotFlag(dictionary);
            view = new FlagBitsPaneView(
                    flag.getFlagType(), flag.getFlagValue(), flag.getFlagBits(), flag.getColumnNames());
        }

        if (flagType.equals(COSName.FF))
        {
            flag = new FieldFlag(dictionary);
            view = new FlagBitsPaneView(
                    flag.getFlagType(), flag.getFlagValue(), flag.getFlagBits(), flag.getColumnNames());
        }

        if (flagType.equals(COSName.PANOSE))
        {
            flag = new PanoseFlag(dictionary);
            view = new FlagBitsPaneView(
                    flag.getFlagType(), flag.getFlagValue(), flag.getFlagBits(), flag.getColumnNames());
        }
    }

    /**
     * Returns the Pane itself
     * @return JPanel instance
     */
    public JPanel getPane()
    {
        return view.getPanel();
    }
}
