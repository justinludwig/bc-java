package org.bouncycastle.crypto.test;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.encoders.Hex;

public class DRBGTestVector
{
        private Digest _digest;
        private EntropySource _eSource;
        private boolean _pr;
        private String _nonce;
        private String _personalisation;
        private int _ss;
        private String[] _ev;
        private List _ai = new ArrayList();

        public DRBGTestVector(Digest digest, EntropySource eSource, boolean predictionResistance, String nonce, int securityStrength, String[] expected)
        {
            _digest = digest;
            _eSource = eSource;
            _pr = predictionResistance;
            _nonce = nonce;
            _ss = securityStrength;
            _ev = expected;
            _personalisation = "";
        }

        public Digest getDigest()
        {
            return _digest;
        }

        public DRBGTestVector addAdditionalInput(String input)
        {
            _ai.add(input);

            return this;
        }

        public DRBGTestVector setPersonalizationString(String p)
        {
            _personalisation = p;

            return this;
        }

        public EntropySource entropySource()
        {
            return _eSource;
        }

        public boolean predictionResistance()
        {
            return _pr;
        }

        public String nonce()
        {
            return _nonce;
        }

        public String personalisation()
        {
            return _personalisation;
        }

        public int securityStrength()
        {
            return _ss;
        }

        public String[] expectedValue()
        {
            return _ev;
        }

        public byte[] additionalInput(int position)
        {
            int len = _ai.size();
            byte[] rv;
            if (position >= len)
            {
                rv = null;
            }
            else
            {
                rv = Hex.decode((String)(_ai.get(position)));
            }
            return rv;
        }

    }