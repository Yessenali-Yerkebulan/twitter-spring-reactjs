import {selectIsListLoaded, selectIsListLoading, selectListItem} from "../selectors";
import {createMockRootState, mockBaseListResponse} from "../../../../util/testHelper";
import {LoadingStatus} from "../../../types/common";

describe("list selectors:", () => {
    
    describe("selectListItem", () => {
        it("should return BaseListResponse", () => {
            expect(selectListItem(createMockRootState())).toBe(mockBaseListResponse);
        });
    });

    describe("selectIsListLoading", () => {
        it("should return correct result", () => {
            expect(selectIsListLoading(createMockRootState(LoadingStatus.LOADING))).toBe(true);
        });
    });

    describe("selectIsListLoaded", () => {
        it("should return correct result", () => {
            expect(selectIsListLoaded(createMockRootState(LoadingStatus.LOADED))).toBe(true);
        });
    });
});
