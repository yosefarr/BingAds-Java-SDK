package com.microsoft.bingads.api.test.entities.targets.campaign.bids.negativelocation.write;

import com.microsoft.bingads.api.test.entities.targets.campaign.bids.negativelocation.BulkCampaignNegativeLocationTargetBidTest;
import com.microsoft.bingads.bulk.entities.BulkCampaignNegativeLocationTargetBid;
import com.microsoft.bingads.bulk.entities.LocationTargetType;
import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BulkCampaignNegativeLocationTargetWriteToRowValuesNegativeLocationTypeTest extends BulkCampaignNegativeLocationTargetBidTest {

    @Parameter(value = 1)
    public LocationTargetType expectedResult;
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Postal Code", LocationTargetType.POSTAL_CODE},
            {"City", LocationTargetType.CITY},
            {"Metro Area", LocationTargetType.METRO_AREA},
            {"State", LocationTargetType.STATE},
            {"Country", LocationTargetType.COUNTRY}
        });
    }

    @Test
    public void testWrite() {
        this.<LocationTargetType>testWriteProperty("Sub Type", this.datum, this.expectedResult, new BiConsumer<BulkCampaignNegativeLocationTargetBid, LocationTargetType>() {
            @Override
            public void accept(BulkCampaignNegativeLocationTargetBid c, LocationTargetType v) {
                c.setLocationType(v);
            }
        });
    }
}
