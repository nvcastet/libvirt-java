package org.libvirt;

import static org.libvirt.Library.libvirt;

import java.util.ArrayList;
import java.util.List;

import org.libvirt.jna.virDomainStatsRecord;
import org.libvirt.jna.virTypedParameter;

import com.sun.jna.Pointer;

public class DomainStatsRecords {
    private Pointer nativeArray;
    private int arraySize;
    private List<DomainStatsRecord> statsRecords;
    private Connect connect;

    public DomainStatsRecords(Pointer array, int size, Connect conn) {
        nativeArray = array;
        arraySize = size;
        connect = conn;
        LoadData();
    }

    private void LoadData() {
        statsRecords = new ArrayList<DomainStatsRecord>();
        if (arraySize <= 0) {
            return;
        }
        virDomainStatsRecord firstRecord = new virDomainStatsRecord(nativeArray);
        virDomainStatsRecord[] records = (virDomainStatsRecord[]) firstRecord.toArray(arraySize);
        for (virDomainStatsRecord record : records) {
            List<TypedParameter> paramList = new ArrayList<TypedParameter>();
            if (record.nparams > 0) {
                virTypedParameter[] params = (virTypedParameter[]) record.params.toArray(record.nparams);
                for (virTypedParameter param : params) {
                    paramList.add(TypedParameter.create(param));
                }
            }
            DomainStatsRecord r = new DomainStatsRecord(new Domain(connect, record.dom), paramList);
            statsRecords.add(r);
        }
    }

    public List<DomainStatsRecord> getStatsRecords() {
        return statsRecords;
    }

    @Override
    protected void finalize() throws LibvirtException {
        free();
    }

    /**
     * Frees this stats object.
     * structure is freed and should not be used thereafter.
     *
     * @throws LibvirtException
     */
    public void free() throws LibvirtException {
        if (nativeArray != null) {
            libvirt.virDomainStatsRecordListFree(nativeArray);
            nativeArray = null;
        }
    }

}
