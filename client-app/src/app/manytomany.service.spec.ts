import { TestBed, inject } from '@angular/core/testing';

import { ManytomanyService } from './manytomany.service';

describe('ManytomanyService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ManytomanyService]
    });
  });

  it('should be created', inject([ManytomanyService], (service: ManytomanyService) => {
    expect(service).toBeTruthy();
  }));
});
